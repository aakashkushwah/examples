package com.akushwah.camel.sample.test;

import java.sql.SQLException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQXAConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.akushwah.camel.sample.attempts.Attempt2Route;
import com.akushwah.camel.sample.utils.AuditLogDao;
import com.akushwah.camel.sample.utils.EmbeddedActiveMQBroker;
import com.akushwah.camel.sample.utils.EmbeddedDataSourceFactory;
import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.ExceptionThrowingProcessor;
import com.akushwah.camel.sample.utils.H2MemoryDatabaseExample;
import com.akushwah.camel.sample.utils.ManagerDao;
import com.akushwah.camel.sample.utils.PersonDao;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jms.AtomikosConnectionFactoryBean;

public class Attempt2Test extends CamelTestSupport {
	public static final int MAX_WAIT_TIME = 10000;

	@Rule
	public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker("embeddedBroker");
	private AtomikosConnectionFactoryBean atomikosConnectionFactoryBean;
	private UserTransactionManager userTransactionManager;
	private PersonDao personDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;
	private AuditLogDao auditLogDao;

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		System.out.println("Creating route builder");
		return new Attempt2Route(personDao, employeeDao, managerDao);
	}

	@Override
	protected CamelContext createCamelContext() throws Exception {
		System.out.println("Creating camel context");
		SimpleRegistry registry = new SimpleRegistry();

		// JMS setup
		ActiveMQXAConnectionFactory xaConnectionFactory = new ActiveMQXAConnectionFactory();
		xaConnectionFactory.setBrokerURL(broker.getTcpConnectorUri());
		registry.put("connectionFactory", xaConnectionFactory);

		atomikosConnectionFactoryBean = new AtomikosConnectionFactoryBean();
		atomikosConnectionFactoryBean.setXaConnectionFactory(xaConnectionFactory);
		atomikosConnectionFactoryBean.setUniqueResourceName("xa.activemq");
		atomikosConnectionFactoryBean.setMaxPoolSize(10);
		atomikosConnectionFactoryBean.setIgnoreSessionTransactedFlag(false);
		registry.put("atomikos.connectionFactory", atomikosConnectionFactoryBean);

		// JDBC setup
		JdbcDataSource jdbcDataSource = EmbeddedDataSourceFactory.getJdbcDataSource("schema.sql");

		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSource(jdbcDataSource);
		atomikosDataSourceBean.setUniqueResourceName("xa.h2");
		registry.put("atomikos.dataSource", atomikosDataSourceBean);

		// Atomikos setup
		userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		userTransactionManager.init();

		UserTransactionImp userTransactionImp = new UserTransactionImp();
		userTransactionImp.setTransactionTimeout(300);

		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(userTransactionManager);
		jtaTransactionManager.setUserTransaction(userTransactionImp);

		registry.put("jta.transactionManager", jtaTransactionManager);

		SpringTransactionPolicy propagationRequired = new SpringTransactionPolicy();
		propagationRequired.setTransactionManager(jtaTransactionManager);
		propagationRequired.setPropagationBehaviorName("PROPAGATION_REQUIRED");
		registry.put("PROPAGATION_REQUIRED", propagationRequired);

		CamelContext camelContext = new DefaultCamelContext(registry);

		{
			SqlComponent sqlComponent = new SqlComponent();
			sqlComponent.setDataSource(atomikosDataSourceBean);
			camelContext.addComponent("sql", sqlComponent);
		}
		{
			// transactional JMS component
			ActiveMQComponent activeMQComponent = new ActiveMQComponent();
			activeMQComponent.setConnectionFactory(atomikosConnectionFactoryBean);
			activeMQComponent.setTransactionManager(jtaTransactionManager);
			camelContext.addComponent("jms", activeMQComponent);
		}
		{
			// non-transactional JMS component setup for test purposes
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
			connectionFactory.setBrokerURL(broker.getTcpConnectorUri());

			ActiveMQComponent activeMQComponent = new ActiveMQComponent();
			activeMQComponent.setConnectionFactory(connectionFactory);
			activeMQComponent.setTransactionManager(jtaTransactionManager);
			camelContext.addComponent("nonTxJms", activeMQComponent);
		}
		auditLogDao = new AuditLogDao(jdbcDataSource);
		personDao = new PersonDao(jdbcDataSource);
		employeeDao = new EmployeeDao(jdbcDataSource);
		managerDao = new ManagerDao(jdbcDataSource);
		return camelContext;
	}

//	@After
//	public void closeAtomikosResources() {
//		userTransactionManager.close();
//		atomikosConnectionFactoryBean.close();
//	}

	// @Test
	public void testTransactedNoException() throws InterruptedException {
		String message = "aakash1,1;kushwah1,2;hcl1,3";

		template.sendBody("jms:inbound", message);

		assertNull(consumer.receiveBody("jms:ActiveMQ.DLQ", MAX_WAIT_TIME, String.class));

		assertEquals(message, consumer.receiveBody("jms:outbound", MAX_WAIT_TIME, String.class));
	}

	@Test
	public void testTransactedExceptionThrown() throws InterruptedException {
		String message = "aakash1,1;kushwah1,2;hcl1,3";
		assertEquals(0, auditLogDao.getAuditCount(message));

		MockEndpoint mockOut = getMockEndpoint("mock:out");
		mockOut.whenAnyExchangeReceived(new ExceptionThrowingProcessor());

		final MockEndpoint mockError = getMockEndpoint("mock:error");
		mockError.expectedMessageCount(1);
		mockError.expectedBodiesReceived(message);

		// even though the route throws an exception, we don't have to deal with it here
		// as we
		// don't send the message to the route directly, but to the broker, which acts
		// as a middleman.
		// template.sendBody("nonTxJms:inbound", message);
		template.sendBody("jms:inbound", message);

		// when transacted, ActiveMQ receives a failed signal when the exception is
		// thrown
		// the message is placed into a dead letter queue
		// assertEquals(message, consumer.receiveBody("jms:ActiveMQ.DLQ", MAX_WAIT_TIME,
		// String.class));
		System.out.println("********************");
		// String dlqMsg = consumer.receiveBody("seda:mydlc", MAX_WAIT_TIME,
		// String.class);
		// System.out.println("dlqMsg "+dlqMsg);
		// assertEquals(message, dlqMsg);
		// assertNull(consumer.receiveBody("jms:ActiveMQ.DLQ", MAX_WAIT_TIME,
		// String.class));

		// the sending operation is performed in the same transaction, so it is rolled
		// back
		String outBoundMessage = consumer.receiveBody("jms:outbound", MAX_WAIT_TIME, String.class);
		System.out.println("Outbound message " + outBoundMessage);
		// assertNull(consumer.receiveBody("jms:outbound", MAX_WAIT_TIME,
		// String.class));
		// assertEquals(message, consumer.receiveBody("jms:outbound", MAX_WAIT_TIME,
		// String.class));
		

		assertEquals(0, auditLogDao.getAuditCount(message));
		assertEquals(2, managerDao.getManagerCount());
	}
	
	@After
	public void printRecords() {
		System.out.println("********************");
		System.out.println("Testing Records");
		try {
			H2MemoryDatabaseExample.printManagerRecords();
		} catch (SQLException e) {
			System.out.println("Issue in reading records");
			e.printStackTrace();
		}
	}
}
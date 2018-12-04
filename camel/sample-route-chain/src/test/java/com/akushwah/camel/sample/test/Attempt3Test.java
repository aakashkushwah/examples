package com.akushwah.camel.sample.test;

import java.sql.SQLException;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jms.connection.JmsTransactionManager;

import com.akushwah.camel.sample.attempts.Attempt2Route;
import com.akushwah.camel.sample.utils.AuditLogDao;
import com.akushwah.camel.sample.utils.EmbeddedActiveMQBroker2;
import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.ExceptionThrowingProcessor;
import com.akushwah.camel.sample.utils.H2MemoryDatabaseExample;
import com.akushwah.camel.sample.utils.ManagerDao;
import com.akushwah.camel.sample.utils.PersonDao;

public class Attempt3Test extends CamelTestSupport {
	public static final int MAX_WAIT_TIME = 10000;

	@Rule
	public EmbeddedActiveMQBroker2 broker = new EmbeddedActiveMQBroker2();

	private PersonDao personDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;
	private AuditLogDao auditLogDao;

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		System.out.println("Creating route builder");
		return new Attempt2Route(personDao, employeeDao, managerDao);
	}

	/**
	 * <bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
	 * <property name="connectionFactory" ref="connectionFactory" />
	 * <property name="receiveTimeout" value="100" /> <!-- This is important... -->
	 * <property name="sessionTransacted" value="true" /> </bean>
	 * 
	 * <bean id="connectionFactory" class=
	 * "org.apache.activemq.ActiveMQConnectionFactory" depends-on="brokerService">
	 * <property name="brokerURL" value="vm://localhost?async=false" /> </bean>
	 */

	@Override
	protected CamelContext createCamelContext() throws Exception {
		SimpleRegistry registry = new SimpleRegistry();

		registry.put("connectionFactory", broker.getConnectionFactory());
		JmsTransactionManager jmsTransactionManager = broker.getTransactionManager();
		jmsTransactionManager.setConnectionFactory(broker.getConnectionFactory());
		registry.put("jmsTransactionManager", jmsTransactionManager);

		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(jmsTransactionManager);
		policy.setPropagationBehaviorName("PROPAGATION_REQUIRED");
		registry.put("PROPAGATION_REQUIRED", policy);

		CamelContext camelContext = new DefaultCamelContext(registry);

		{
			SqlComponent sqlComponent = new SqlComponent();
			sqlComponent.setDataSource(broker.getDataSource());
			camelContext.addComponent("sql", sqlComponent);
		}
		{
			// transactional JMS component
//			ActiveMQComponent activeMQComponent = new ActiveMQComponent();
//			activeMQComponent.setConnectionFactory(broker.getConnectionFactory());
//			activeMQComponent.setTransactionManager(jmsTransactionManager);
			camelContext.addComponent("jms", broker.getComponent());
		}

		personDao = new PersonDao(broker.getDataSource());
		employeeDao = new EmployeeDao(broker.getDataSource());
		managerDao = new ManagerDao(broker.getDataSource());
		auditLogDao = new AuditLogDao(broker.getDataSource());
		return camelContext;
	}

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
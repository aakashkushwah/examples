package com.akushwah.camel.sample.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.connection.JmsTransactionManager;

import com.akushwah.camel.sample.attempts.Attempt1Route;
import com.akushwah.camel.sample.attempts.Attempt2Route;
import com.akushwah.camel.sample.utils.EmbeddedActiveMQBroker;
import com.akushwah.camel.sample.utils.EmbeddedDataSourceFactory;
import com.akushwah.camel.sample.utils.H2MemoryDatabaseExample;

public class Attempt2Test extends CamelTestSupport {
	public static final int MAX_WAIT_TIME = 1000;

	@Rule
	public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker("embeddedBroker");
	private DataSource dataSource;

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new Attempt2Route(dataSource);
	}

	@Override
	protected CamelContext createCamelContext() throws Exception {
		SimpleRegistry registry = new SimpleRegistry();
		dataSource = EmbeddedDataSourceFactory.getDataSource("schema.sql");

		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		registry.put("transactionManager", transactionManager);

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(broker.getTcpConnectorUri());
		registry.put("connectionFactory", connectionFactory);

		JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
		jmsTransactionManager.setConnectionFactory(connectionFactory);
		registry.put("jmsTransactionManager", jmsTransactionManager);

		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(jmsTransactionManager);
		policy.setPropagationBehaviorName("PROPAGATION_REQUIRED");
		registry.put("PROPAGATION_REQUIRED", policy);

		CamelContext camelContext = new DefaultCamelContext(registry);

		ActiveMQComponent activeMQComponent = new ActiveMQComponent();
		activeMQComponent.setConnectionFactory(connectionFactory);
		activeMQComponent.setTransactionManager(jmsTransactionManager);
		camelContext.addComponent("jms", activeMQComponent);

		return camelContext;
	}

	@Test
	public void testTransactedExceptionThrown() throws InterruptedException {
		String message = "this message will explode";

		MockEndpoint mockOut = getMockEndpoint("mock:out");
		mockOut.setExpectedMessageCount(1);

		// even though the route throws an exception, we don't have to deal with it here
		// as we
		// don't send the message to the route directly, but to the broker, which acts
		// as a middleman.
		template.sendBody("jms:inbound", message);

		// when transacted, ActiveMQ receives a failed signal when the exception is
		// thrown
		// the message is placed into a dead letter queue
		assertEquals(message, consumer.receiveBody("jms:ActiveMQ.DLQ", MAX_WAIT_TIME, String.class));

		// the sending operation is performed in the same transaction, so it is rolled
		// back
		assertNull(consumer.receiveBody("jms:outbound", MAX_WAIT_TIME, String.class));
	}
}
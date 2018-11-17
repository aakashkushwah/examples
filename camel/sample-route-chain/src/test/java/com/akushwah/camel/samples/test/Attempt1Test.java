package com.akushwah.camel.samples.test;

import java.sql.SQLException;

import javax.sql.DataSource;

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
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.akushwah.camel.sample.attempts.Attempt1Route;
import com.akushwah.camel.sample.utils.EmbeddedDataSourceFactory;
import com.akushwah.camel.sample.utils.H2MemoryDatabaseExample;

public class Attempt1Test extends CamelTestSupport {
    @Produce(uri = "direct:A")
    ProducerTemplate in;

    @EndpointInject(uri = "mock:out")
    MockEndpoint out;
    
    private DataSource dataSource;

    @Override
    protected CamelContext createCamelContext() throws Exception {
        SimpleRegistry registry = new SimpleRegistry();
        dataSource = EmbeddedDataSourceFactory.getDataSource("schema.sql");
        //registry.put("auditDataSource", auditDataSource);

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        registry.put("transactionManager", transactionManager);

        SpringTransactionPolicy propagationRequired = new SpringTransactionPolicy();
        propagationRequired.setTransactionManager(transactionManager);
        propagationRequired.setPropagationBehaviorName("PROPAGATION_REQUIRED");
        registry.put("PROPAGATION_REQUIRED", propagationRequired);


        CamelContext camelContext = new DefaultCamelContext(registry);

        SqlComponent sqlComponent = new SqlComponent();
        sqlComponent.setDataSource(dataSource);
        camelContext.addComponent("sql", sqlComponent);

        return camelContext;
    }
    
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new Attempt1Route(dataSource);
    }

    @Test
    public void testInOnlyMessage() {
        String message = "akash,1;kushwah,2";

        out.setExpectedMessageCount(1);

//        in.sendBody(message);
        
        try {
        	String response = (String) in.requestBody(message);
            assertEquals(message, response);
			assertMockEndpointsSatisfied();
		} catch (Exception e) {
			System.out.println("Issues while testing");
			e.printStackTrace();
		}
        
        System.out.println("********************");
        System.out.println("Testing Records");
        try {
			H2MemoryDatabaseExample.printEmployeeRecords();
			H2MemoryDatabaseExample.printPersonRecords();
		} catch (SQLException e) {
			System.out.println("Issue in reading records");
			e.printStackTrace();
		}
        
    }
    
}

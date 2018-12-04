/*
 * Copyright (C) Scott Cranton, Jakub Korab, and Christian Posta
 * https://github.com/CamelCookbook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akushwah.camel.sample.utils;

import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.activemq.store.jdbc.JDBCPersistenceAdapter;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.camel.test.AvailablePortFinder;
import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;

/**
 * JUnit Test aspect that creates an embedded ActiveMQ broker at the beginning of eac h test and shuts it down after.
 */
public class EmbeddedActiveMQBroker2 extends ExternalResource {

    private final Logger log = LoggerFactory.getLogger(EmbeddedActiveMQBroker2.class);
    private final String brokerId;
    private BrokerService brokerService;
    private final String tcpConnectorUri;
    private DataSource dataSource;
    private ActiveMQConnectionFactory connectionFactory;
    private ActiveMQComponent activeMQComponent;
    private PooledConnectionFactory pooledConnectionFactory;
    private JmsTransactionManager transactionManager;
      
    public EmbeddedActiveMQBroker2() {
    	this.brokerId = "embeddedBroker";
        tcpConnectorUri = "tcp://localhost:" + AvailablePortFinder.getNextAvailable();
        connectionFactory = new org.apache.activemq.spring.ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(tcpConnectorUri);
		ActiveMQPrefetchPolicy prefetchPolicy = new ActiveMQPrefetchPolicy();
		prefetchPolicy.setAll(0);
		connectionFactory.setPrefetchPolicy(prefetchPolicy);
		connectionFactory.setTrustAllPackages(true);
		
		pooledConnectionFactory =  new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(connectionFactory);
        transactionManager = new JmsTransactionManager(pooledConnectionFactory);
        
        
        JmsConfiguration amqCamelConfig = new JmsConfiguration(pooledConnectionFactory);
        amqCamelConfig.setTransactionManager(transactionManager);
        amqCamelConfig.setTransacted(true);
        amqCamelConfig.setConcurrentConsumers(1);
        amqCamelConfig.setDeliveryPersistent(true);
        
        activeMQComponent = new ActiveMQComponent();
        activeMQComponent.setConfiguration(amqCamelConfig);
        
        JmsTemplate jmsTemplate = new JmsTemplate(pooledConnectionFactory);
        jmsTemplate.setSessionTransacted(true);

//		JmsTemplate jmsTemplate = new JmsTemplate();
//		jmsTemplate.setConnectionFactory(connectionFactory);
//		jmsTemplate.setSessionTransacted(true);
//
		dataSource = EmbeddedDataSourceJMSAwareFactory.getDataSource(jmsTemplate);
		brokerService = new BrokerService();
		JDBCPersistenceAdapter jdbcPersistenceAdapter = new JDBCPersistenceAdapter();
		jdbcPersistenceAdapter.setDataSource(dataSource);
		jdbcPersistenceAdapter.setCreateTablesOnStartup(true);
//
        brokerService.setBrokerId(this.brokerId);
        brokerService.setPersistent(false);
        brokerService.setUseJmx(false);
        try {
//        	brokerService.setPersistenceAdapter(jdbcPersistenceAdapter);
        	brokerService.addConnector(tcpConnectorUri);
        } catch (Exception e) {
            throw new RuntimeException("Problem creating brokerService", e);
        }
    }

    @Override
    protected void before() throws Throwable {
        log.info("Starting embedded broker[{}] on {}", brokerId, tcpConnectorUri);
        brokerService.start();
    }

    @Override
    protected void after() {
        try {
            log.info("Stopping embedded broker[{}]", brokerId);
            brokerService.stop();
        } catch (Exception e) {
            throw new RuntimeException("Exception shutting down broker service", e);
        }
    }

    public String getTcpConnectorUri() {
        return tcpConnectorUri;
    }
    
    public PooledConnectionFactory getConnectionFactory() {
    	return pooledConnectionFactory;
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }
    
    public JmsTransactionManager getTransactionManager() {
    	return transactionManager;
    }
    
    public ActiveMQComponent getComponent() {
    	return activeMQComponent;
    }
}

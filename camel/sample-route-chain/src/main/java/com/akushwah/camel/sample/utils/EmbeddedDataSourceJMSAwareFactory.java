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

import org.springframework.jms.core.JmsTemplate;

/**
 * Utility class that centralises the wiring of a DataSource to the embedded database.
 */
public class EmbeddedDataSourceJMSAwareFactory {

    public static DataSource getDataSource(JmsTemplate jmsTemplate) {
        return getJdbcDataSource(jmsTemplate);
    }

    public static JmsTransactionAwareDataSourceProxy getJdbcDataSource(JmsTemplate jmsTemplate) {
        
        JmsTransactionAwareDataSourceProxy dataSourceProxy = new JmsTransactionAwareDataSourceProxy();
        dataSourceProxy.setTargetDataSource(EmbeddedDataSourceFactory.getDataSource("schema.sql"));
        dataSourceProxy.setJmsTemplate(jmsTemplate);

        return dataSourceProxy;
    }

    private EmbeddedDataSourceJMSAwareFactory() {
    }
}

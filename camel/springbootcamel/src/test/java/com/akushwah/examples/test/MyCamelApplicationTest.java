package com.akushwah.examples.test;

import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.camel.test.spring.EnableRouteCoverage;

import com.akushwah.examples.sbc.SbcApplication;

import static org.junit.Assert.assertTrue;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = SbcApplication.class)
@EnableRouteCoverage
public class MyCamelApplicationTest {

    @Autowired
    private CamelContext camelContext;

    @Test
    public void shouldProduceMessages() throws Exception {
        // we expect that one or more messages is automatic done by the Camel
        // route as it uses a timer to trigger
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();

        assertTrue(notify.matches(10, TimeUnit.SECONDS));
    }

}
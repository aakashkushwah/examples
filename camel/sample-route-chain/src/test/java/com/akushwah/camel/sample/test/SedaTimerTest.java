package com.akushwah.camel.sample.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.akushwah.camel.sample.LongRunningProcessor;
import com.akushwah.camel.sample.SedaTimerRoute;

public class SedaTimerTest extends CamelTestSupport {
    @EndpointInject(uri = "mock:out")
    MockEndpoint out;

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new SedaTimerRoute();
    }

    @Test
    public void testLoadBalancing() throws Exception {
        final int pingCount = 10;

        out.setMinimumExpectedMessageCount(pingCount);
        Thread.sleep((pingCount * SedaTimerRoute.TIMER_PERIOD) + LongRunningProcessor.DELAY_TIME);
        out.assertIsSatisfied();
    }

}

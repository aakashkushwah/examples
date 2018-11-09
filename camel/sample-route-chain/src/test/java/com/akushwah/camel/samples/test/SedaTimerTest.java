package com.akushwah.camel.samples.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.akushwah.camel.samples.LongRunningProcessor;
import com.akushwah.camel.samples.SedaTimerRoute;

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

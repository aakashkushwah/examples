package com.akushwah.camel.sample;

import org.apache.camel.builder.RouteBuilder;

public class SedaTimerRoute extends RouteBuilder {
    public final static int TIMER_PERIOD = 200;

    @Override
    public void configure() throws Exception {
        from("timer:ping?period=" + TIMER_PERIOD).startupOrder(2)
            .transform(constant("Ping"))
            .to("seda:longRunningPhase");

        from("seda:longRunningPhase?concurrentConsumers=15").startupOrder(1)
            .process(new LongRunningProcessor())
            .to("mock:out");
    }
    
}

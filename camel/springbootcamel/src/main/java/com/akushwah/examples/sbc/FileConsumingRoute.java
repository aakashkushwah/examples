package com.akushwah.examples.sbc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileConsumingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:{{start.endpoint}}")
        	.to("seda:longRunningPhase");

        from("seda:longRunningPhase?concurrentConsumers=15").startupOrder(1)
            .process(new MyProcessor())
            .log("Set message to ${body}")
            .to("{{end.endpoint}}");
    }
}

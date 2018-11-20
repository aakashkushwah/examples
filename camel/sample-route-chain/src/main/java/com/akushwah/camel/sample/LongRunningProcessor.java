package com.akushwah.camel.sample;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LongRunningProcessor implements Processor {

    final public static int DELAY_TIME = 3000;

    @Override
    public void process(Exchange exchange) throws Exception {
        Thread.sleep(DELAY_TIME);
        exchange.getIn().setBody("Long running process finished");
    }

}

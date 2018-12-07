package com.akushwah.examples.sbc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("myp")
public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Insider My processor");
		System.out.println(exchange.getIn().getBody(String.class));		
	}
	
	
}

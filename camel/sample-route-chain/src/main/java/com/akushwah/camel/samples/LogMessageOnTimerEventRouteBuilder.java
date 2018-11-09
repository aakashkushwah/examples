package com.akushwah.camel.samples;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class LogMessageOnTimerEventRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("timer:logMessageTimer?period=1s")
				.log("Event triggered by ${property.CamelTimerName}" + " at ${header.CamelTimerFiredTime}");
	}
	
	public static void main(String[] args) throws Exception{
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(
				 new LogMessageOnTimerEventRouteBuilder());
		context.start();
		Thread.sleep(5000);
		context.stop();
	}
}

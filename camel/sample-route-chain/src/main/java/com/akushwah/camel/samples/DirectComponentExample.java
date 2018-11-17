package com.akushwah.camel.samples;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class DirectComponentExample {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new DirectComponentRouteBuilder());
		context.start();
		Thread.sleep(5000);
		context.stop();
	}
}

class DirectComponentRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:./files/in") // receive a file
				.to("direct:processTheFile") // send to direct endpoint
				.log("Body is now ${body}")
				.to("direct:prefixBodyWithHello"); // will print 'Eggs!'

		// meanwhile...
		from("direct:processTheFile") // receive from direct endpoint
				.setBody(x -> {
					x.getMessage().setBody("Eggs!!");
					return x;
				}); // modify the message body

		from("direct:prefixBodyWithHello").transform(simple("Hello, ${body}")).log("Prefixed message: ${body}").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                Message in = exchange.getIn();
                System.out.println(in.getBody().toString());
            }
        });

	}

}

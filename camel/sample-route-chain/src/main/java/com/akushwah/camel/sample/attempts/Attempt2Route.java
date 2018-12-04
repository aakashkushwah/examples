package com.akushwah.camel.sample.attempts;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.ManagerDao;
import com.akushwah.camel.sample.utils.PersonDao;

public class Attempt2Route extends RouteBuilder {
	public final static int TIMER_PERIOD = 1000;

	private PersonDao personDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;
	public static AtomicInteger COUNT = new AtomicInteger(0);

	public Attempt2Route(PersonDao personDao, EmployeeDao employeeDao, ManagerDao managerDao) {
		this.personDao = personDao;
		this.employeeDao = employeeDao;
		this.managerDao = managerDao;
	}

	@Override
	public void configure() throws Exception {
//		errorHandler(deadLetterChannel("seda:mydlc").onExceptionOccurred(new Processor() {
//			@Override
//			public void process(Exchange exchange) throws Exception {
//				System.out.println("In Error Exception " + exchange.getException());
//				System.out.println("In Error Body " + exchange.getIn().getBody(String.class));
//			}
//		}));
		errorHandler(defaultErrorHandler().maximumRedeliveries(0));

		from("jms:inbound?transacted=true")
	        .transacted("PROPAGATION_REQUIRED")
	        .log("Processing message: ${body}")
//	        .process(new MyProcessor1(personDao))
//			.process(new MyProcessor2(employeeDao))
	        .setHeader("message", body())
			.to("sql:insert into audit_log values (1, :#message)")
			.to("sql:insert into manager values (2, :#message)")
	        .to("jms:outbound") // this send is transacted, so the message should not be sent
	        .to("mock:out");
		
		from("jms:ActiveMQ.DLQ")
			.to("sql:insert into manager values (3, 'manager1')")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					System.out.println("In Error Exception " + exchange.getException());
					System.out.println("In Error Body " + exchange.getIn().getBody(String.class));
					managerDao.saveManager("managerx", 4);
				}
			})
			.to("log:dlc?showAll=true&multiline=true")
			.to("mock:error");
	}

}

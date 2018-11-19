package com.akushwah.camel.sample.attempts;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;

import com.akushwah.camel.sample.utils.AkException;
import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.PersonDao;

public class Attempt1Route extends RouteBuilder {
	public final static int TIMER_PERIOD = 1000;

	private PersonDao personDao;
	private EmployeeDao employeeDao;

	public Attempt1Route(DataSource dataSource) {
		this.personDao = new PersonDao(dataSource);
		this.employeeDao = new EmployeeDao(dataSource);
	}

	@Override
	public void configure() throws Exception {
		errorHandler(defaultErrorHandler().maximumRedeliveries(2));
		onException(Exception.class).process(exchange->{
			System.out.println("*********Inside On Exception***********");
			Thread.sleep(3000);
			employeeDao.saveEmployee("hcl1", 9);
//			employeeDao.saveEmployee("aakash", 3);
			System.out.println("*********Exiting On Exception***********");
		});
		
		onException(AkException.class).process(exchange->{
			System.out.println("*********Inside On AkException***********");
			Thread.sleep(3000);
			employeeDao.saveEmployee("hcl2", 10);
//			employeeDao.saveEmployee("aakash", 3);
			System.out.println("*********Exiting On AkException***********");
		});

		from("direct:A").to("seda:myrunningphase");
//		from("direct:A").transform(constant("Ping")).to("seda:myrunningphase");

		from("seda:myrunningphase")
			.startupOrder(1)
			.transacted()
			.process(new MyProcessor1(personDao))
			.process(new MyProcessor2(employeeDao))
			.to("mock:out");
	}

}

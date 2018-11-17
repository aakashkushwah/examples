package com.akushwah.camel.sample.attempts;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;

import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.PersonDao;

public class Attempt1Route extends RouteBuilder {
	public final static int TIMER_PERIOD = 1000;

	private DataSource dataSource;

	public Attempt1Route(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure() throws Exception {
		errorHandler(defaultErrorHandler().maximumRedeliveries(2));

		from("direct:A").transform(constant("Ping")).to("seda:myrunningphase");

		from("seda:myrunningphase").startupOrder(1).transacted().process(new MyProcessor1(new PersonDao(dataSource)))
				.process(new MyProcessor2(new EmployeeDao(dataSource))).to("mock:out");
	}

}

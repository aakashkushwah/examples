package com.akushwah.camel.sample.attempts;

import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;

import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.ManagerDao;
import com.akushwah.camel.sample.utils.MyExecutor;
import com.akushwah.camel.sample.utils.PersonDao;
import com.akushwah.camel.sample.utils.WorkerThread;

public class Attempt1Route extends RouteBuilder {
	public final static int TIMER_PERIOD = 1000;

	private PersonDao personDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;
	private static AtomicInteger COUNT = new AtomicInteger(0);

	public Attempt1Route(DataSource dataSource) {
		this.personDao = new PersonDao(dataSource);
		this.employeeDao = new EmployeeDao(dataSource);
		this.managerDao = new ManagerDao(dataSource);
	}

	@Override
	public void configure() throws Exception {
		// onException(Exception.class).maximumRedeliveries(0).process(exchange->{
		// System.out.println("*********Inside On Exception***********");
		// Thread.sleep(3000);
		// managerDao.saveManager("hcl1", COUNT.incrementAndGet());
		// System.out.println("*********Exiting On Exception***********");
		// });
		//
		// onException(AkException.class).maximumRedeliveries(0).process(exchange->{
		// System.out.println("*********Inside On AkException***********");
		// Thread.sleep(3000);
		// managerDao.saveManager("manager", COUNT.incrementAndGet());
		// System.out.println("*********Exiting On AkException***********");
		// });
		errorHandler(defaultErrorHandler().onExceptionOccurred(exchange -> {
			System.out.println("*********Inside On error handler***********");
			Thread.sleep(3000);
			MyExecutor.getInstance().execute(new WorkerThread<String>(str -> {
				try {
					System.out.println("Body is "+str);
					managerDao.saveManager("errorHandler", COUNT.incrementAndGet());
				} catch (Exception e) {
					System.out.println("&&&&&&&&&&");
					e.printStackTrace();
				}
			}, exchange.getIn().getBody(String.class)));
			System.out.println("*********Exiting On error handler***********");
		}));

		from("direct:A").to("seda:myrunningphase");
		// from("direct:A").transform(constant("Ping")).to("seda:myrunningphase");

		from("seda:myrunningphase").startupOrder(1).transacted().process(new MyProcessor1(personDao))
				.process(new MyProcessor2(employeeDao)).to("mock:out");
	}

}

package com.akushwah.camel.sample.attempts;

import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;

import com.akushwah.camel.sample.utils.EmployeeDao;
import com.akushwah.camel.sample.utils.ManagerDao;
import com.akushwah.camel.sample.utils.MyExecutor;
import com.akushwah.camel.sample.utils.PersonDao;
import com.akushwah.camel.sample.utils.WorkerThread;

public class Attempt2Route extends RouteBuilder {
	public final static int TIMER_PERIOD = 1000;

	private PersonDao personDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;
	private static AtomicInteger COUNT = new AtomicInteger(0);

	public Attempt2Route(DataSource dataSource) {
		this.personDao = new PersonDao(dataSource);
		this.employeeDao = new EmployeeDao(dataSource);
		this.managerDao = new ManagerDao(dataSource);
	}

	@Override
	public void configure() throws Exception {
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

		from("jms:inbound")
			.transacted()
			.process(new MyProcessor1(personDao))
			.process(new MyProcessor2(employeeDao))
			.to("jms:outbound")
			.to("mock:out");
	}

}

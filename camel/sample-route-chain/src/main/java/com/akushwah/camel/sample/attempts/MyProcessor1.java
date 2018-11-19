package com.akushwah.camel.sample.attempts;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.akushwah.camel.sample.utils.PersonDao;

public class MyProcessor1 implements Processor {

	private PersonDao personDao;

	public MyProcessor1(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("*******Starting Processor 1*********");
		String records = exchange.getIn().getBody(String.class);
		String[] recordStrs = records.split(";");
		for (String recordStr : recordStrs) {
			String name = recordStr.split(",")[0];
			int id = Integer.parseInt(recordStr.split(",")[1]);
			personDao.savePerson(name, id);
		}
		System.out.println("*******Exiting Processor 1*********");
		Thread.sleep(3000);
	}

}
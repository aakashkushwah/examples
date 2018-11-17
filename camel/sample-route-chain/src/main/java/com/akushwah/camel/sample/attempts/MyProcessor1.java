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
		Thread.sleep(3000);
		String records = exchange.getIn().getBody(String.class);
		String[] recordStrs = records.split(";");
		for (String recordStr : recordStrs) {
			String name = recordStr.split(",")[0];
			int id = Integer.parseInt(recordStr.split(",")[1]);
			personDao.savePerson(name, id);
		}
	}

}
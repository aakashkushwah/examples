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
        exchange.getIn().setBody("Processor 1 finished");
        
        Thread.sleep(3000);
        personDao.saveMessage("Kushwah", 3);
    }

}
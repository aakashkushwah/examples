package com.akushwah.camel.sample.attempts;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.akushwah.camel.sample.utils.EmployeeDao;

public class MyProcessor2 implements Processor {

    final public static int DELAY_TIME = 3000;
    
    private EmployeeDao empDao;
	
	public MyProcessor2(EmployeeDao empDao) {
		this.empDao = empDao;
	}

    @Override
    public void process(Exchange exchange) throws Exception {
        Thread.sleep(DELAY_TIME);
        exchange.getIn().setBody("Processor 2 finished");
        empDao.saveEmployee("HCL", 4);
//        empDao.saveEmployee("HCL", 4);
    }

}
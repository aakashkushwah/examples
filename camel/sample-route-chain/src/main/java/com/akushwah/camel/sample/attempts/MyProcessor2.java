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
    	System.out.println("*******Starting Processor 2*********");
        String records = exchange.getIn().getBody(String.class);
		String[] recordStrs = records.split(";");
		for (String recordStr : recordStrs) {
			String name = recordStr.split(",")[0];
			int id = Integer.parseInt(recordStr.split(",")[1]);
			empDao.saveEmployee(name, id);
		}
		System.out.println("*******Exiting Processor 2*********");
		Thread.sleep(DELAY_TIME);
    }

}
package com.akushwah.camel.sample.utils;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getEmployeeCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
    }
    
    public int saveEmployee(String name, int id) throws Exception {
    	if(name.equalsIgnoreCase("Aakash")) {
    		System.out.println("Throwing exception due to name being aakash");
    		throw new Exception("Aakash Found");
    	}else if(name.equalsIgnoreCase("hcl")) {
    		System.out.println("Throwing akexception due to name being hcl");
    		throw new AkException("hcl found");
    	}
        return jdbcTemplate.update("INSERT INTO EMPLOYEE" + "(id, name) values" + "(?,?)", id, name);
    }
}

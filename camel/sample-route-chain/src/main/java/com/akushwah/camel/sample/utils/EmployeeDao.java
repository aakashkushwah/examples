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
    
    public int saveEmployee(String name, int id) {
        return jdbcTemplate.update("INSERT INTO EMPLOYEE" + "(id, name) values" + "(?,?)", id, name);
    }
}

package com.akushwah.camel.sample.utils;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao {
	private final JdbcTemplate jdbcTemplate;

    public PersonDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getPersonCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PERSON", Integer.class);
    }
    
    public int saveMessage(String name, int id) {
        return jdbcTemplate.update("INSERT INTO PERSON" + "(id, name) values" + "(?,?)", id, name);
    }
}

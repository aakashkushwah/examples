package com.akushwah.camel.sample.utils;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ManagerDao {
	private final JdbcTemplate jdbcTemplate;

    public ManagerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getManagerCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MANAGER", Integer.class);
    }
    
    public int saveManager(String name, int id) throws Exception {
        return jdbcTemplate.update("INSERT INTO MANAGER" + "(id, name) values" + "(?,?)", id, name);
    }
}

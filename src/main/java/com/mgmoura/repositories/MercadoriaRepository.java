package com.mgmoura.repositories;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MercadoriaRepository {

	private JdbcTemplate jdbcTemplate;
	
	public MercadoriaRepository(DataSource dataSource) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
}

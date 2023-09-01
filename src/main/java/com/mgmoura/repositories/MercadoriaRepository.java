package com.mgmoura.repositories;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mgmoura.entities.Mercadoria;

public class MercadoriaRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public MercadoriaRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	public void create(Mercadoria mercadoria) throws Exception {
		
		String sql = "INSERT into mercadoria(nomeMercadoria, descricao, quantidade, tipo, dataEntrada) VALUES(?,?,?,?,?) " ;
		
		Object[] params = {
				
				mercadoria.getNomeMercadoria(),
				mercadoria.getDescricao(),
				mercadoria.getQuantidade(),
				mercadoria.getTipo(),
				mercadoria.getDataEntrada()
		};
		
		jdbcTemplate.update(sql , params);
	}

}

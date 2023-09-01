package com.mgmoura.repositories;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mgmoura.entities.Mercadoria;

@Repository
public class MercadoriaRepository {

	private JdbcTemplate jdbcTemplate;
	
	public MercadoriaRepository(DataSource dataSource) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(Mercadoria mercadoria) throws Exception{
		
		String sql = "INSERT into mercadoria(nomeMercadoria, descricao, quantidade, dataEntrada, tipo) VALUES(?,?,?,?,?)" ;
		
		Object[] params = {
				
				mercadoria.getNomeMercadoria(),
				mercadoria.getDescricao(),
				mercadoria.getQuantidade(),
				mercadoria.getDataEntrada(),
				mercadoria.getTipo()
		};
		
		jdbcTemplate.update(sql , params);
		
	}
}

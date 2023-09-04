package com.mgmoura.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	
	public List<Mercadoria> findAll(Date dataMin, Date dataMax) throws Exception{
		
		String sql = "SELECT * FROM mercadoria WHERE dataEntrada BETWEEN ? AND ? ORDER BY dataEntrada";
		
		Object[] params = {
				new java.sql.Date(dataMin.getTime()),
				new java.sql.Date(dataMax.getTime()),				
		};
		
		List<Mercadoria> mercadorias = jdbcTemplate.query(sql, params , new RowMapper<Mercadoria>() {

			@Override
			public Mercadoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setId(rs.getInt("id"));
				mercadoria.setNomeMercadoria(rs.getString("nomeMercadoria"));
				mercadoria.setQuantidade(rs.getInt("quantidade"));
				mercadoria.setDescricao(rs.getString("descricao"));
				mercadoria.setTipo(rs.getInt("tipo"));
				mercadoria.setDataEntrada(rs.getDate("dataEntrada"));
								
				return mercadoria;
			}
			
		});
		return mercadorias;
		
	}

}



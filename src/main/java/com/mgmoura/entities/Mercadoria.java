package com.mgmoura.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Mercadoria {
	
	private Integer id;
	private String nomeMercadoria;
	private String descricao;
	private Integer quantidade;
	private Integer tipo;
	private Date dataEntrada;


}

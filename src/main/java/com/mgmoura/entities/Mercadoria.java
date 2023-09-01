package com.mgmoura.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mercadoria {
	
	private Integer id;
	private String nomeMercadoria;
	private String descricao;
	private Integer quantidade;
	private Integer tipo;
	private Date dataEntrada;


}

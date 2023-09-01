package com.mgmoura.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.entities.Mercadoria;
import com.mgmoura.repositories.MercadoriaRepository;

@Controller
public class CadastroMercadoriasController {
	
	@Autowired
	MercadoriaRepository mercadoriaRepository;
	
	
	@RequestMapping(value="/")
	public ModelAndView cadastroMercadorias() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro-mercadorias");
		
		return modelAndView;
	}

	
	@RequestMapping(value = "/cadastro-mercadorias-post")
	public ModelAndView cadastroMercadoriasPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("cadastro-mercadorias");
		
		try {
			Mercadoria mercadoria = new Mercadoria();
			
			mercadoria.setNomeMercadoria(request.getParameter("nomeMercadoria"));
			mercadoria.setDescricao(request.getParameter("descricao"));
			mercadoria.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			mercadoria.setTipo(Integer.parseInt(request.getParameter("tipo")));
			mercadoria.setDataEntrada(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataEntrada")));
			
			mercadoriaRepository.create(mercadoria);
			
			modelAndView.addObject("mensagem" , "Mercadoria cadastrada com sucesso.");
			
			
		}catch (Exception e) {
			
			modelAndView.addObject("mensagem" , "Erro: " + e.getMessage());
			
		}
		
		return modelAndView;
	}
}



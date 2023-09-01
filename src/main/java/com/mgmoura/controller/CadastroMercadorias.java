package com.mgmoura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroMercadorias {
	
	//@RequestMapping(value = "/cadastro-mercadorias")
	@RequestMapping(value="/")
	public ModelAndView cadastroMercadorias() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro-mercadorias");
		
		return modelAndView;
	}

}



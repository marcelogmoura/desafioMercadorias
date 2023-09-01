package com.mgmoura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultarMercadorias {
	
	@RequestMapping(value = "/consultar-mercadorias")
	public ModelAndView consultarMercadorias() {
		
		ModelAndView modelAndView = new ModelAndView("consultar-mercadorias");
		
		return modelAndView;
	}

}

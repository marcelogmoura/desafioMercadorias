package com.mgmoura.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.entities.Mercadoria;
import com.mgmoura.repositories.MercadoriaRepository;

@Controller
public class ConsultarMercadoriasController {
	
	@Autowired
	MercadoriaRepository mercadoriaRepository;
	
	@RequestMapping(value = "/consultar-mercadorias")
	public ModelAndView consultarMercadorias() {
		ModelAndView modelAndView = new ModelAndView("consultar-mercadorias");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "consultar-mercadorias-post" , method = RequestMethod.POST)
	public ModelAndView consultarMercadoriasPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("consultar-mercadorias");
		
		try {
			
			String dataInicio = request.getParameter("dataInicio");
			String dataFim = request.getParameter("dataFim");
			
			List<Mercadoria> mercadorias = mercadoriaRepository.findAll(
					new SimpleDateFormat("yyyy-MM-dd").parse(dataInicio),
					new SimpleDateFormat("yyyy-MM-dd").parse(dataFim));
			
			if(mercadorias.size() > 0) {
				modelAndView.addObject("lista_mercadorias" , mercadorias);
				
			}else {
				modelAndView.addObject("mensagem_alerta" , "Nenhuma mercadoria encontrada no período");
			}
			
			modelAndView.addObject("dt_inicio", dataInicio);
			modelAndView.addObject("dt_fim", dataFim);
			
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro" , e.getMessage());
			
		}
		
		return modelAndView;
				
		
	}


}

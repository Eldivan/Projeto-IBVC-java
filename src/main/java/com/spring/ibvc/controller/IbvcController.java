package com.spring.ibvc.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ibvc.model.Evento;
import com.spring.ibvc.service.IbvcService;

@Controller
public class IbvcController {
	
	@Autowired
	IbvcService ibvcService;
	
	@RequestMapping(value="/eventos", method = RequestMethod.GET)
	public ModelAndView getEventos() {
		ModelAndView mv = new ModelAndView("eventos");
		List<Evento> eventos= ibvcService.findAll();
		mv.addObject("evento" , eventos);
		return mv;
	}
	
	@RequestMapping(value="/eventos/{id}", method = RequestMethod.GET)
	public ModelAndView getEventoDetails(@PathVariable("id")long id) {
		ModelAndView mv = new ModelAndView("eventoDetails");
		Evento evento = ibvcService.findById(id);
		mv.addObject("evento" , evento);
		return mv;
	}
	
	
	@RequestMapping(value="/novoevento", method = RequestMethod.GET)
	public String getEventoForm() {
		return "eventoForm";
	}
	
	
	@RequestMapping(value="/novoevento", method = RequestMethod.POST)
	public String salvarEvento(@Valid Evento evento, BindingResult result, RedirectAttributes attributes,@RequestParam("fileEvento")MultipartFile file){
	
			try {
				evento.setImagem(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Campos obrigatorios devem ser preenchidos.");
			return "redirect:/novoevento";
		}
		
		 ibvcService.save(evento);
		 return "redirect:/eventos";
	}
	
		@GetMapping("/imagemevento/{id}")
		@ResponseBody
		public byte[] exibirImagem (@PathVariable("id")long id){
			Evento evento = this.ibvcService.findById(id);
			return evento.getImagem();
		}
	
}

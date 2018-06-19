package com.codingdojo.dojos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.service.DojoNinjaService;

@Controller
public class DojoNinjaController {
	
	private final DojoNinjaService dojoNinjaService;
	
	public DojoNinjaController(DojoNinjaService dojoNinjaService) {
		this.dojoNinjaService = dojoNinjaService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/dojoninjas/Index.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newdojo(@ModelAttribute Dojo dojo) {
		return "/dojoninjas/NewDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoninjas/NewDojo.jsp";
		} else {
			dojoNinjaService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String newninja(@ModelAttribute Ninja ninja, Model model) {
		List<Dojo> tempDojo = dojoNinjaService.allDojo();
		model.addAttribute("dojo", tempDojo);
		return "/dojoninjas/NewNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoninjas/NewNinja.jsp";
		} else {
			dojoNinjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoNinjaService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojoninjas/Show.jsp";
	}
}

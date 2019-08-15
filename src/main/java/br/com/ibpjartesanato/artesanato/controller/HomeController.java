package br.com.ibpjartesanato.artesanato.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibpjartesanato.artesanato.service.MaterialService;

@Controller
@RequestMapping(path="/")
public class HomeController {

	@Autowired
	private MaterialService service;
	
	@GetMapping
	public String findAll() {
		
		return "home";
	}
}

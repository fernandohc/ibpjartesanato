package br.com.ibpjartesanato.artesanato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibpjartesanato.artesanato.service.MaterialService;
import br.com.ibpjartesanato.artesanato.service.UnidadeMedidaService;

@Controller
@RequestMapping(path="/materiais")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@GetMapping
	public String findAll() {
		
		return "materiais";
	}
	
//	@PostMapping("/save")
//	public ModelAndView save(@Valid Post post, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return add(post);
//		}
//		
//		service.save(post);
//		
//		return findAll();
//	}
	
//	@PostMapping("/salvar")
//	public ModelAndView save(@Valid Material material, BindingResult result) {
//		
//		System.out.println("Entrou em salvar");
//		if(result.hasErrors()) {
//			System.out.println("Ocorreu erro!");
//		}
//		service.save(material);
//		
//		return findAll();
//	}
}

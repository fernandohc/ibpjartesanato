package br.com.ibpjartesanato.artesanato.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibpjartesanato.artesanato.entity.Material;
import br.com.ibpjartesanato.artesanato.service.MaterialService;
import br.com.ibpjartesanato.artesanato.service.UnidadeMedidaService;

@Controller
@RequestMapping(path="/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@GetMapping
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/material");
		mv.addObject("materiais", materialService.findAll());
		mv.addObject("medidas", unidadeMedidaService.findAll());
		
		return mv;
	}
	
//	@GetMapping("/add")
//	public ModelAndView add(Post post) {
//		
//		ModelAndView mv = new ModelAndView("/postAdd");
//		mv.addObject("post", post);
//		
//		return mv;
//	}
	
//	@GetMapping("/edit/{id}")
//	public Post edit(@PathVariable("id") Long id) {
//		
//		return service.findOne(id);
//	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		materialService.delete(id);
		
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Material material, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		materialService.save(material);
		
		return findAll();
	}
}

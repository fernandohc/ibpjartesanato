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
import br.com.ibpjartesanato.artesanato.entity.Peca;
import br.com.ibpjartesanato.artesanato.service.MaterialService;
import br.com.ibpjartesanato.artesanato.service.PecaService;

@Controller
@RequestMapping(path="/")
public class HomeController {

	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private PecaService pecaService;
	
	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pecas", pecaService.findAll());
		mv.addObject("materiais", materialService.findAll());
		
		return mv;
	}
	
	@PostMapping("/salvaPeca")
	public ModelAndView salva(@Valid Peca peca, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		pecaService.save(peca);
		
		return findAll();
	}
	
	@PostMapping("/alteraPeca")
	public ModelAndView alterar(@Valid Peca nova, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		
		Peca alterada = pecaService.findOne(nova.getId());
		alterada.setNome(nova.getNome());
		alterada.setDescricao(nova.getDescricao());
		alterada.setHrsProducao(nova.getHrsProducao());
		alterada.setPctLucro(nova.getPctLucro());
		pecaService.save(alterada);
		
		return findAll();
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		pecaService.delete(id);
		
		return findAll();
	}
}

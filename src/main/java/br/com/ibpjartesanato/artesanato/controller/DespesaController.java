package br.com.ibpjartesanato.artesanato.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibpjartesanato.artesanato.entity.Despesa;
import br.com.ibpjartesanato.artesanato.service.DespesaService;

@Controller
@RequestMapping("/despesa")
public class DespesaController {
	
	@Autowired
	private DespesaService despesaService;

	@GetMapping
	public ModelAndView carregarRegistros() {
		
		ModelAndView mv = new ModelAndView("/despesa");
		mv.addObject("despesasFixas", despesaService.listarDespesasFixas());
		List<Despesa> des = despesaService.listarDespesasVariaveis();
		mv.addObject("despesasVariaveis", despesaService.listarDespesasVariaveis());
		
		return mv;
	}
	
	@PostMapping("/salvarDespesa")
	public ModelAndView save(@Valid Despesa despesa, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		despesaService.salvar(despesa);
		
		return carregarRegistros();
	}
	
	@PostMapping("/alterarDespesa")
	public ModelAndView alterar(@Valid Despesa nova, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		
		Despesa alterada = despesaService.findOne(nova.getId());
		alterada.setNome(nova.getNome());	
		despesaService.salvar(alterada);
		
		return carregarRegistros();
	}
}

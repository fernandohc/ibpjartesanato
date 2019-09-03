package br.com.ibpjartesanato.artesanato.controller;

import java.time.LocalDate;
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
import br.com.ibpjartesanato.artesanato.entity.DespesaLancamento;
import br.com.ibpjartesanato.artesanato.entity.DespesaPeriodo;
import br.com.ibpjartesanato.artesanato.service.DespesaLancamentoService;
import br.com.ibpjartesanato.artesanato.service.DespesaPeriodoService;
import br.com.ibpjartesanato.artesanato.service.DespesaService;

@Controller
@RequestMapping("/despesa")
public class DespesaController {
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private DespesaPeriodoService despesaPeriodoService;
	
	@Autowired
	private DespesaLancamentoService despesaLancamentoService;

	@GetMapping
	public ModelAndView carregarRegistros() {
		ModelAndView mv = new ModelAndView("/despesa");
		LocalDate dataAtual = LocalDate.now();
		DespesaLancamento despesaLancamento = despesaLancamentoService.buscaPorData(dataConvertida(dataAtual));
		
		mv.addObject("despesas", despesaService.getMapDespesasFixas());
		mv.addObject("despesaLancamento", despesaLancamento);
		mv.addObject("despesasVariaveis", despesaService.listarDespesasVariaveis());
		mv.addObject("despesasFixas", despesaService.listarDespesasFixas());
		mv.addObject("despesasPeriodo", despesaPeriodoService.listar(despesaLancamento.getId()));
		mv.addObject("dataAtual", dataAtual);
		
		
		
		return mv;
	}
	
	private LocalDate dataConvertida(LocalDate dataAtual) {
		return dataAtual.withDayOfMonth(1);
	}

	@PostMapping("/salvarDespesa")
	public ModelAndView save(@Valid Despesa despesa, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		despesaService.salvar(despesa);
		
		return carregarRegistros();
	}
	
	@PostMapping("/salvarDespesaPeriodo")
	public ModelAndView salvarDespesaPeriodo(@Valid DespesaPeriodo despesaPeriodo, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		despesaPeriodoService.salvar(despesaPeriodo);
		
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

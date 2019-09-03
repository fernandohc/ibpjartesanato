package br.com.ibpjartesanato.artesanato.controller;

import java.text.DecimalFormat;

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
import br.com.ibpjartesanato.artesanato.entity.MaterialProducao;
import br.com.ibpjartesanato.artesanato.entity.Peca;
import br.com.ibpjartesanato.artesanato.service.MaterialProducaoService;
import br.com.ibpjartesanato.artesanato.service.MaterialService;
import br.com.ibpjartesanato.artesanato.service.PecaService;
import br.com.ibpjartesanato.artesanato.service.UnidadeMedidaService;

@Controller
@RequestMapping(path="/")
public class HomeController {

	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private MaterialProducaoService materialProducaoService;
	
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	
	@GetMapping
	public ModelAndView carregarRegistros() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pecas", pecaService.listar());
		mv.addObject("materiais", materialService.getMapMateriais());
		mv.addObject("medidas", unidadeMedidaService.getMapMedidas());
		mv.addObject("materiaisProducao", materialProducaoService.listar());
		
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView atualizar(@PathVariable("id") Long id) {
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pecas", pecaService.listar());
		mv.addObject("materiaisProducao", materialProducaoService.findByPecaId(id));	
		mv.addObject("materiais", materialService.getMapMateriais());
		mv.addObject("medidas", unidadeMedidaService.getMapMedidas());
		mv.addObject("idPecaSelecionada", id);
		
		return mv;
	}
	
	@PostMapping("/salvaPeca")
	public ModelAndView salvar(@Valid Peca peca, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		pecaService.salvar(peca);
		
		return carregarRegistros();
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
		pecaService.salvar(alterada);
		
		return carregarRegistros();
	}
	
	@GetMapping("/deletePeca/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		pecaService.remover(id);
		
		return carregarRegistros();
	}
	
	@PostMapping("/salvaMaterialProducao")
	public ModelAndView salvaMaterialProducao(@Valid MaterialProducao novo, BindingResult result) {
			
		Material materialSelecionado = materialService.findOne(novo.getMaterial().getId());
		if(materialSelecionado.getUnidadeMedida().getTipo().equals(novo.getUnidadeMedidaSelecionada().getTipo())) {
			materialProducaoService.calculaValor(novo);
		} else {
			throw new RuntimeException("A unidade de medida selecionada é incompatível com a medida da peça");
		}
		materialProducaoService.salvar(novo);
		
		return carregarRegistros();
	}
	
	@PostMapping("/alteraMaterialProducao")
	public ModelAndView alterarMaterialProducao(@Valid MaterialProducao novo, BindingResult result) {
		
//		if(result.hasErrors()) {
//			return add(material);
//		}
		Material materialSelecionado = materialService.findOne(novo.getMaterial().getId());
		if(materialSelecionado.getUnidadeMedida().getTipo().equals(novo.getUnidadeMedidaSelecionada().getTipo())) {
			MaterialProducao alterado = materialProducaoService.findOne(novo.getId());
			alterado.setMaterial(novo.getMaterial());
			alterado.setQtdUtilizada(novo.getQtdUtilizada());
			alterado.setUnidadeMedidaSelecionada(novo.getUnidadeMedidaSelecionada());
			materialProducaoService.calculaValor(alterado);
			materialProducaoService.salvar(alterado);
		} else {
			throw new RuntimeException("A unidade de medida selecionada é incompatível com a medida da peça");
		}
			
		return carregarRegistros();
	}
	
	@GetMapping("/deleteMaterialProducao/{id}")
	public ModelAndView removerMaterialProducao(@PathVariable("id") Long id) {
		
		materialProducaoService.remover(id);
		
		return carregarRegistros();
	}
}

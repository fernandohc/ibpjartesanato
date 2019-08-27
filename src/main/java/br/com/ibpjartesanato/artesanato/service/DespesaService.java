package br.com.ibpjartesanato.artesanato.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.Despesa;
import br.com.ibpjartesanato.artesanato.entity.TipoDespesa;
import br.com.ibpjartesanato.artesanato.repository.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;
	
	public List<Despesa> listarDespesasFixas() {
		return repository.findByTipoDespesa(TipoDespesa.FIXA);
	}

	public List<Despesa> listarDespesasVariaveis() {
		return repository.findByTipoDespesa(TipoDespesa.VARIAVEL);
	}
	
	public Despesa salvar(@Valid Despesa despesa) {
		return repository.saveAndFlush(despesa);
	}

	public Despesa findOne(Long id) {
		return repository.getOne(id);
	}
}

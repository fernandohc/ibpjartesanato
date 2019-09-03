package br.com.ibpjartesanato.artesanato.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.DespesaLancamento;
import br.com.ibpjartesanato.artesanato.repository.DespesaLancamentoRepository;

@Service
public class DespesaLancamentoService {

	@Autowired
	private DespesaLancamentoRepository repository;
	
	public List<DespesaLancamento> listar() {
		return repository.findAll();
	}
	
	public DespesaLancamento buscaPorData(LocalDate dataConvertida) {
		return repository.findByMesAno(dataConvertida);
	}
	
	public DespesaLancamento findOne(Long id) {
		return repository.getOne(id);
	}
	
	public DespesaLancamento salvar(DespesaLancamento despesaLancamento) {
		return repository.saveAndFlush(despesaLancamento);
	}
	
	public void remover(Long id) {
		repository.deleteById(id);
	}


}

package br.com.ibpjartesanato.artesanato.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.DespesaLancamento;
import br.com.ibpjartesanato.artesanato.entity.DespesaPeriodo;
import br.com.ibpjartesanato.artesanato.repository.DespesaPeriodoRepository;

@Service
public class DespesaPeriodoService {

	@Autowired
	private DespesaPeriodoRepository repository;
	
	public List<DespesaPeriodo> listar() {
		return repository.findAll();
	}
	
	public DespesaPeriodo findOne(Long id) {
		return repository.getOne(id);
	}
	
	public DespesaPeriodo salvar(DespesaPeriodo despesaPeriodo) {
		return repository.saveAndFlush(despesaPeriodo);
	}
	
	public void remover(Long id) {
		repository.deleteById(id);
	}

	public List<DespesaPeriodo> listar(Long id) {
		return repository.findByDespesaLancamentoId(id);
	}


}

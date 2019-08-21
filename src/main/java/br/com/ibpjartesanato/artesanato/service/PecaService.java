package br.com.ibpjartesanato.artesanato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ibpjartesanato.artesanato.entity.Material;
import br.com.ibpjartesanato.artesanato.entity.Peca;
import br.com.ibpjartesanato.artesanato.repository.PecaRepository;

@Service
public class PecaService {
	
	@Autowired
	private PecaRepository repository;
	
	public List<Peca> listar() {
		return repository.findAll();
	}
	
	public Peca findOne(Long id) {
		return repository.getOne(id);
	}
	
	public Peca salvar(Peca peca) {
		return repository.saveAndFlush(peca);
	}
	
	public void remover(Long id) {
		repository.deleteById(id);
	}
}

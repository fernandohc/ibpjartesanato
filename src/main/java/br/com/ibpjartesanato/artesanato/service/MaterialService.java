package br.com.ibpjartesanato.artesanato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.Material;
import br.com.ibpjartesanato.artesanato.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository repository;
	
	public List<Material> findAll() {
		return repository.findAll();
	}
	
	public Material findOne(Long id) {
		return repository.getOne(id);
	}
	
	public Material save(Material post) {
		return repository.saveAndFlush(post);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

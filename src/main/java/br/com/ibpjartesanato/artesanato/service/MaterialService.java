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
	
//	public Post findOne(Long id) {
//		return repository.findOne(id);
//	}
	
	public Material save(Material material) {
		return repository.saveAndFlush(material);
	}
	
//	public void delete(Long id) {
//		repository.delete(id);
//	}
}

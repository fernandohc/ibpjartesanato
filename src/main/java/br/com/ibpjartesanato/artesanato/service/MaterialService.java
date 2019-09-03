package br.com.ibpjartesanato.artesanato.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.Material;
import br.com.ibpjartesanato.artesanato.entity.UnidadeMedida;
import br.com.ibpjartesanato.artesanato.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository repository;
	
	public List<Material> listar() {
		return repository.findAll();
	}
	
	public Material findOne(Long id) {
		return repository.getOne(id);
	}
	
	public Material salvar(Material material) {
		return repository.saveAndFlush(material);
	}
	
	public void remover(Long id) {
		repository.deleteById(id);
	}
	
	public HashMap<Long, String> getMapMateriais() {
		List<Material> materiais = this.listar();
		
		HashMap<Long, String> mapMateriais = new HashMap<Long, String>();
		mapMateriais.put((long) -1, "Selecione...");
		
		for (Material material : materiais) {
			mapMateriais.put(material.getId(), material.getNome());
		}
		
		return mapMateriais;
	}
}

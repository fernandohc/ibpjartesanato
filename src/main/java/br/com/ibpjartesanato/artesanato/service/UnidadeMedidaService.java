package br.com.ibpjartesanato.artesanato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.UnidadeMedida;
import br.com.ibpjartesanato.artesanato.repository.UnidadeMedidaRepository;


@Service
public class UnidadeMedidaService {
	
	@Autowired
	private UnidadeMedidaRepository repository;
	
	public List<UnidadeMedida> findAll() {
		return repository.findAll();
	}
	
//	public static List<String> lista() {
//		List<String> lista = new LinkedList<String>();
//		lista.add("Centímetros");
//		lista.add("Metros");
//		return lista;
//	}
}

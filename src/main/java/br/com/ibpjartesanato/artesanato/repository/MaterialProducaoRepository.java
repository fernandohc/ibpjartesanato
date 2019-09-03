package br.com.ibpjartesanato.artesanato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibpjartesanato.artesanato.entity.MaterialProducao;

@Repository
public interface MaterialProducaoRepository extends JpaRepository<MaterialProducao, Long> {

	List<MaterialProducao> findByPecaId(Long id);
}

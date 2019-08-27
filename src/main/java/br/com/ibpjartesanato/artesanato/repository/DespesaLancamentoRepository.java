package br.com.ibpjartesanato.artesanato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibpjartesanato.artesanato.entity.DespesaLancamento;

@Repository
public interface DespesaLancamentoRepository extends JpaRepository<DespesaLancamento, Long> {	
}

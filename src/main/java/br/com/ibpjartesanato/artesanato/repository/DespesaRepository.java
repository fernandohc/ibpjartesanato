package br.com.ibpjartesanato.artesanato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibpjartesanato.artesanato.entity.Despesa;
import br.com.ibpjartesanato.artesanato.entity.TipoDespesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

	List<Despesa> findByTipoDespesa(TipoDespesa fixa);

}

package br.com.ibpjartesanato.artesanato.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibpjartesanato.artesanato.entity.DespesaLancamento;
import br.com.ibpjartesanato.artesanato.entity.DespesaPeriodo;

@Repository
public interface DespesaLancamentoRepository extends JpaRepository<DespesaLancamento, Long> {	

	DespesaLancamento findByMesAno(LocalDate dataConvertida);
	
}

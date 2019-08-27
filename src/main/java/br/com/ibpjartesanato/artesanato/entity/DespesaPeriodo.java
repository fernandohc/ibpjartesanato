package br.com.ibpjartesanato.artesanato.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="tb_DespesaPeriodo")
public class DespesaPeriodo {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Despesa despesa;
	
	@ManyToOne
	private DespesaLancamento despesaLancamento;
	
	private BigDecimal valor;
}

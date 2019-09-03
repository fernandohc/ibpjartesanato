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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public DespesaLancamento getDespesaLancamento() {
		return despesaLancamento;
	}

	public void setDespesaLancamento(DespesaLancamento despesaLancamento) {
		this.despesaLancamento = despesaLancamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}

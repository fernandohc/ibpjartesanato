package br.com.ibpjartesanato.artesanato.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_Despesa")
public class Despesa {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private float pct; 

	private TipoDespesa tipoDespesa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPct() {
		return pct;
	}

	public void setPct(float pct) {
		this.pct = pct;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
}

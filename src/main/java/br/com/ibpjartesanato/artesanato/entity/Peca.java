package br.com.ibpjartesanato.artesanato.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name="tb_peca")
public class Peca {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable = false)
	@NotEmpty(message = "Descrição é uma informação obrigatória.")
	private String descricao;
	
	@Column(nullable = false)
	private float pctLucro;
	
	@Column(nullable = false)
//	@NotEmpty(message = "Horas de produção é uma informação obrigatória.")
	private LocalTime hrsProducao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPctLucro() {
		return pctLucro;
	}

	public void setPctLucro(float pctLucro) {
		this.pctLucro = pctLucro;
	}

	public LocalTime getHrsProducao() {
		return hrsProducao;
	}

	public void setHrsProducao(LocalTime hrsProducao) {
		this.hrsProducao = hrsProducao;
	}
}

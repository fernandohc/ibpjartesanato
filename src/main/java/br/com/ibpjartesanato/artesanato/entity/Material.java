package br.com.ibpjartesanato.artesanato.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity(name="tb_material")
public class Material {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable = false)
	@NotEmpty(message = "Descrição é uma informação obrigatória.")
	private String descricao;
	
	@Column(nullable = false)
//	@NotEmpty(message = "Quantidade é uma informação obrigatória.")
	private float quantidade;
	
	@Column(nullable = false)
//	@NotEmpty(message = "Preço é uma informação obrigatória.")
	private BigDecimal preco;

	@ManyToOne
	private UnidadeMedida unidadeMedida;
	
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

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}

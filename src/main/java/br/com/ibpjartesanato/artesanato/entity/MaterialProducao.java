package br.com.ibpjartesanato.artesanato.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="tb_MaterialProducao")
public class MaterialProducao {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Peca peca;
	
	@ManyToOne
	private Material material;
	
	private float qtdUtilizada;
	
	@ManyToOne
	private UnidadeMedida unidadeMedidaSelecionada;
	
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public float getQtdUtilizada() {
		return qtdUtilizada;
	}

	public void setQtdUtilizada(float qtdUtilizada) {
		this.qtdUtilizada = qtdUtilizada;
	}

	public UnidadeMedida getUnidadeMedidaSelecionada() {
		return unidadeMedidaSelecionada;
	}

	public void setUnidadeMedidaSelecionada(UnidadeMedida unidadeMedidaSelecionada) {
		this.unidadeMedidaSelecionada = unidadeMedidaSelecionada;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}

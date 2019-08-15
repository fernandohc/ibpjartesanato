package br.com.ibpjartesanato.artesanato.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_unidademedida")
public class UnidadeMedida {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private TipoUnidadeMedida tipo;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoUnidadeMedida getTipo() {
		return tipo;
	}
	public void setTipo(TipoUnidadeMedida tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}

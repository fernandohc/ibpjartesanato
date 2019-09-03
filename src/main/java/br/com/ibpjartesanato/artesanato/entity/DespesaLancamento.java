package br.com.ibpjartesanato.artesanato.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="tb_DespesaLancamento")
public class DespesaLancamento {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "despesaLancamento")
	private List<DespesaPeriodo> despesasPeriodo;
	
	private LocalDate mesAno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DespesaPeriodo> getDespesasPeriodo() {
		return despesasPeriodo;
	}

	public void setDespesasPeriodo(List<DespesaPeriodo> despesasPeriodo) {
		this.despesasPeriodo = despesasPeriodo;
	}

	public LocalDate getMesAno() {
		return mesAno;
	}

	public void setMesAno(LocalDate mesAno) {
		this.mesAno = mesAno;
	}
	
}

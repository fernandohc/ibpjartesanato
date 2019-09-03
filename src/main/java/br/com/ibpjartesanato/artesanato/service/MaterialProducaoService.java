package br.com.ibpjartesanato.artesanato.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibpjartesanato.artesanato.entity.MaterialProducao;
import br.com.ibpjartesanato.artesanato.entity.TipoUnidadeMedida;
import br.com.ibpjartesanato.artesanato.repository.MaterialProducaoRepository;

@Service
public class MaterialProducaoService {
	
	@Autowired
	private MaterialProducaoRepository repository;
	
	public List<MaterialProducao> listar() {
		return repository.findAll();
	}
	
	public MaterialProducao salvar(MaterialProducao materialProducao) {
		return repository.saveAndFlush(materialProducao);
	}

	public List<MaterialProducao> findByPecaId(Long id) {
		return repository.findByPecaId(id);
	}

	public void calculaValor(MaterialProducao novo) {
		if(novo.getUnidadeMedidaSelecionada().getTipo().equals(TipoUnidadeMedida.AREA))
			calculaValorComprimento(novo);
	}

	private void calculaValorComprimento(MaterialProducao novo) {		
		BigDecimal qtdUtilizadaAjustado = new BigDecimal(novo.getQtdUtilizada());
		BigDecimal quantidadeAjustada = new BigDecimal(novo.getMaterial().getQuantidade());
		
		switch(novo.getUnidadeMedidaSelecionada().getId().intValue()) {
		case 0:
			novo.setValor(qtdUtilizadaAjustado.multiply(novo.getMaterial().getPreco()).divide(quantidadeAjustada, RoundingMode.UP).multiply(new BigDecimal("0.01")));
		case 1:
			novo.setValor(qtdUtilizadaAjustado.multiply(novo.getMaterial().getPreco()).divide(quantidadeAjustada, RoundingMode.UP));
			break;
		}
	}

	public MaterialProducao findOne(Long id) {
		return repository.getOne(id);
	}

	public void remover(Long id) {
		repository.deleteById(id);
	}
}

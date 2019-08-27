$(function() {
	criaCombosPaginaInicial();
});

function adicionarPeca() {
	var dadosRequest = preencheCamposPecaRequest();

	$.ajax({
		method : 'POST',
		url : '/salvaPeca',
		data : {
			"nome" : dadosRequest['nome'],
			"descricao" : dadosRequest['descricao'],
			"hrsProducao" : dadosRequest['hrsProducao'],
			"pctLucro" : dadosRequest['pctLucro']
		},
		success : (function(response) {
			window.location = '/';
		})
	})
}

function alterarPeca() {
	var dadosRequest = preencheCamposPecaRequest();
	
	$.ajax({
		method:'POST',
		url: '/alteraPeca',
		data: {
			"id":dadosRequest['id'], 
			"nome" : dadosRequest['nome'],
			"descricao" : dadosRequest['descricao'],
			"hrsProducao" : dadosRequest['hrsProducao'],
			"pctLucro" : dadosRequest['pctLucro']
		},
		success: (function(response) {
			window.location = '/';
		})
	})
}

function preencheCamposPecaRequest() {
	var dados = {};
	dados['id'] = idAtual;
	dados['nome'] = $('#inputNomePecaNovo').val();
	dados['descricao'] = $('#inputDescricaoPecaNovo').val();
	dados['hrsProducao'] = $('#inputHrsProducaoPecaNovo').val();
	dados['pctLucro'] = $('#inputPctLucroPecaNovo').val();

	return dados;
}

function alterarMaterialProducao() {
	var dadosRequest = preencheCamposMaterialProducaoRequest();
	
	$.ajax({
		method:'POST',
		url: '/alteraMaterialProducao',
		data : {
			"id" : dadosRequest['id'],
			"material" : dadosRequest['material'],
			"qtdUtilizada" : dadosRequest['qtdUtilizada'],
			"unidadeMedidaSelecionada" : dadosRequest['unidadeMedidaSelecionada'],
			"peca" : dadosRequest['peca']
		},
		success : (function(response) {
			window.location = '/'+dadosRequest['peca'];
		})
	})
}

function adicionarMaterialProducao() {
	var dadosRequest = preencheCamposMaterialProducaoRequest();

	$.ajax({
		method : 'POST',
		url : '/salvaMaterialProducao',
		data : {
			"material" : dadosRequest['material'],
			"qtdUtilizada" : dadosRequest['qtdUtilizada'],
			"unidadeMedidaSelecionada" : dadosRequest['unidadeMedidaSelecionada'],
			"peca" : dadosRequest['peca']
		},
		success : (function(response) {
			window.location = '/'+dadosRequest['peca'];
		})
	})
}

function preencheCamposMaterialProducaoRequest() {
	var dados = {};
	dados['id'] = idAtual;
	dados['material'] = $('#inputNomeMaterialProducaoNovo').val();
	dados['qtdUtilizada'] = $('#inputQtdUtilizadaMaterialProducaoNovo').val();
	dados['unidadeMedidaSelecionada'] = $('#inputUnidadeMedidaSelecionadaMaterialProducaoNovo').val();
	dados['peca'] = $('#idPecaSelecionada').val();

	return dados;
}

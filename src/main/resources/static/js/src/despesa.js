$(function() {
	criaCombosDespesas();
});

function criaCombosDespesas() {
	arrayDespesasFixas = $('#despesas').val();
	arrayDespesasFixas = arrayDespesasFixas.substring(arrayDespesasFixas.length-1, 1);
	despesasFixas = arrayDespesasFixas.split(",");
}

function adicionarDespesa(tipoDespesa) {
	var dadosRequest = preencheCamposDespesaRequest(tipoDespesa);

	$.ajax({
		method : 'POST',
		url : '/despesa/salvarDespesa',
		data : {
			"nome" : dadosRequest['nome'],
			"tipoDespesa" : dadosRequest['tipoDespesa'],
			"pct" : dadosRequest['pct']
		},
		success : (function(response) {
			window.location = '/despesa';
		})
	})
}

function alterarDespesa(tipoDespesa) {
	var dadosRequest = preencheCamposDespesaRequest(tipoDespesa);

	$.ajax({
		method : 'POST',
		url : '/despesa/alterarDespesa',
		data : {
			"id" : dadosRequest['id'],
			"nome" : dadosRequest['nome'],
			"pct" : dadosRequest['pct']
		},
		success : (function(response) {
			window.location = '/despesa';
		})
	})
}

function adicionarDespesaPeriodo() {
	var dadosRequest = preencheCamposDespesaPeriodoRequest();

	$.ajax({
		method : 'POST',
		url : '/despesa/salvarDespesaPeriodo',
		data : {
			"despesa" : dadosRequest['despesa'],
			"valor" : dadosRequest['valor'],
			"data" : dadosRequest['data'],
			"despesaLancamento" : dadosRequest['despesaLancamento']
		},
		success : (function(response) {
			window.location = '/despesa';
		})
	})
}



function preencheCamposDespesaRequest(tipoDespesa) {
	var dados = {};
	dados['id'] = idAtual;
	dados['nome'] = tipoDespesa == 'FIXA' ? $('#inputNomeDespesaNovo').val() : $('#inputNomeDespesaVariavelNovo').val();
	dados['pct'] = tipoDespesa == 'FIXA' ? 0 : $('#inputPctDespesaVariavelNovo').val();
	dados['tipoDespesa'] = tipoDespesa;
	return dados;
}

function preencheCamposDespesaPeriodoRequest() {
	var dados = {};
	dados['id'] = idAtual;
	dados['despesa'] = $('#inputDespesasDespesaPeriodoNovo').val();
	dados['valor'] = $('#inputValorDespesaPeriodoNovo').val();
	dados['data'] = $('#dataDespesaLancamento').val();
	dados['despesaLancamento'] = $('#despesaLancamentoId').val();
	return dados;
}
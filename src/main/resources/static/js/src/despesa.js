function adicionarDespesa(tipoDespesa) {
	var dadosRequest = preencheCamposDespesaRequest(tipoDespesa);

	$.ajax({
		method : 'POST',
		url : '/despesa/salvarDespesa',
		data : {
			"nome" : dadosRequest['nome'],
			"tipoDespesa" : dadosRequest['tipoDespesa']
		},
		success : (function(response) {
			window.location = '/despesa';
		})
	})
}

function alterarDespesa() {
	var dadosRequest = preencheCamposDespesaRequest();

	$.ajax({
		method : 'POST',
		url : '/despesa/alterarDespesa',
		data : {
			"id" : dadosRequest['id'],
			"nome" : dadosRequest['nome'],
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
	dados['tipoDespesa'] = tipoDespesa;
	return dados;
}
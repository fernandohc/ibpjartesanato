var idAtual;
var idPecaAtual;
var medidas;
var materiais;
var despesasFixas;

function criaLinhaInclusao(...colunas) {
	if ($('#linhaNova'+colunas[0]).length == 0) {
		$('#tabela'+colunas[0]).prepend(criaLinha('Inclusao', ...colunas));
	}
	$('#input'+colunas[1]+colunas[0]+'Novo').focus();
}

function criaLinha(operacao, ...colunas) {
	let linha = document.createElement('tr');
	linha.setAttribute('id', 'linhaNova'+colunas[0]);
	
	for(let i = 1; i < colunas.length; i++) 
		linha.appendChild(criaColuna(colunas[0], colunas[i]));

	let colBtn = document.createElement('td');
	colBtn.appendChild(criaDivBotoes(operacao, colunas[0]));
	linha.appendChild(colBtn);

	return linha;
}

function criaColuna(objeto, campo) {
	let colCampo = document.createElement('td');
	
	if(!campo.startsWith("Combo")) 
		colCampo.appendChild(criaInput(objeto, campo));
	else
		colCampo.appendChild(criaCombo(objeto, campo.slice(5)));
	
	return colCampo;
}

function criaInput(objeto, campo) {
	let inputCampo = document.createElement('input');
	inputCampo.setAttribute('id', 'input' + campo + objeto + 'Novo');
	inputCampo.type = 'text';
	return inputCampo;
}

function criaCombo(objeto, campo) {	
	let combo = document.createElement('select');
	combo.setAttribute('id', 'input'+ campo + objeto +'Novo');
	
	return populaCombo(combo, campo);
}

function populaCombo(combo, objeto) {
	var lista;
	
	if(objeto === 'UnidadeMedidaSelecionada')
		lista = medidas;
	if(objeto === 'Despesas')
		lista = despesasFixas;
	else
		lista = materiais;
	for(let i = 0; i < lista.length; i++) {
		let option = document.createElement('option');
		var arr = lista[i].trim().split("=");
		option.value = arr[0];
		option.innerHTML = arr[1];
		combo.appendChild(option);
	}
	return combo;
}

function criaDivBotoes(operacao, objeto) {
	let divBtns = document.createElement('div');
	divBtns.classList.add('btn-group', 'pull-right');

	if(operacao == 'Inclusao')
		divBtns.appendChild(criaBotaoAdicionar(objeto));		
	else 
		divBtns.appendChild(criaBotaoAlterar(objeto));
	
	divBtns.appendChild(criaBotaoCancelar(objeto));

	return divBtns;
}

function criaBotaoAdicionar(objeto) {
	let button = document.createElement('button');
	button.classList.add('btn', 'btn-sm', 'btn-primary');
	button.setAttribute('id', 'idBtnIncluir'+objeto+'Novo');
	button.innerHTML = 'Incluir';
	button.onclick = function() {;
		adicionar(objeto);
	}

	return button;
}

function criaBotaoAlterar(objeto) {
	let button = document.createElement('button');
	button.classList.add('btn', 'btn-sm', 'btn-primary');
	button.setAttribute('id', 'idBtnAlterar'+objeto+'Novo');
	button.innerHTML = 'Alterar';
	button.onclick = function() {
		alterar(objeto);
	}
	
	return button;
}

function criaBotaoCancelar(objeto) {
	let button = document.createElement('button');
	button.classList.add('btn', 'btn-sm', 'delete', 'btn-danger');
	button.setAttribute('id', 'idBtnCancelar'+objeto+'Novo');
	button.innerHTML = 'Cancelar';
	button.onclick = function() {
		cancelar(objeto);
	}
	return button;
}

function adicionar(objeto) {
	switch(objeto) {
	case 'Peca':
		adicionarPeca();
		break;
	case 'MaterialProducao':
		adicionarMaterialProducao();
		break;
	case 'Despesa':
		adicionarDespesa('FIXA');
		break;
	case 'DespesaVariavel':
		adicionarDespesa('VARIAVEL');
		break;
	case 'DespesaPeriodo':
		adicionarDespesaPeriodo();
		break;
	}
}

function alterar(objeto) {
	switch(objeto) {
	case 'Peca':
		alterarPeca();
		break;
	case 'MaterialProducao':
		alterarMaterialProducao();
		break;
	case 'Despesa':
		alterarDespesa('FIXA');
		break;
	case 'DespesaVariavel':
		alterarDespesa('VARIAVEL');
		break;
	}
}

function cancelar(objeto) {
	
	// Implementar outras
	window.location = '/';
}

function liberaCamposParaEdicao(objetoId, ...colunas) {
	let obj = colunas[0].charAt(0).toLowerCase() + colunas[0].slice(1);		
	idAtual = $('#'+obj+'Id_'+objetoId).val();	
	
	var campos = salvaValoresAtuaisCampos(obj, objetoId, ...colunas);
	
	criaLinhaAlteracao(objetoId, ...colunas); 		
	preencheCamposNovaLinha(campos, ...colunas);
}


function salvaValoresAtuaisCampos(obj, objetoId, ...colunas) {
	let campos = [];
	
	for(var i = 1; i < colunas.length; i++) {
		campos[i] = $('#'+obj+colunas[i]+'_'+objetoId).text();
	}
	
	return campos;
}

function preencheCamposNovaLinha(campos, ...colunas) {
	for(var i = 1; i < colunas.length; i++) {
		if(colunas[i].startsWith('Combo'))
			colunas[i] = colunas[i].slice(5);
		$('#input'+colunas[i]+colunas[0]+'Novo').val(campos[i]);
	}
}

function criaLinhaAlteracao(objetoId, ...colunas) {		
	let obj = colunas[0].charAt(0).toLowerCase() + colunas[0].slice(1);
	
	if($('#linhaNova'+colunas[0]).length == 0) {
		if(!colunas[1].startsWith('Combo'))
			$('#'+obj+colunas[1]+'_'+objetoId).parent().replaceWith(criaLinha('Alteracao', ...colunas));
		else
			$('#'+obj+colunas[1].slice(5)+'_'+objetoId).parent().replaceWith(criaLinha('Alteracao', ...colunas));
	}
	$('#input'+colunas[1]+'Novo').focus();
}

function atualizaPagina(pecaId) {
	
	$.ajax({
		method : 'GET',
		url : '/'+pecaId,
		success : (function(response) {
			window.location = '/'+pecaId;
		})
	})
}

function excluir(Id, objeto) {
	$.ajax({
		method:'GET',
		url: '/delete'+objeto+'/'+Id,
		success: (function(response) {
			window.location = '/'+$('#idPecaSelecionada').val();
		})
	})
}

var form = {
	id: document.getElementById("id"),
	nome: document.getElementById("nome"),
	quantidade: document.getElementById("quantidade"),
	preco: document.getElementById("preco"),
	submit: document.getElementById("btn-submit"),
	
	clear: function() {
		id.value = "";
		nome.value = "";
		quantidade.value = "";
		preco.value = "";
		
	}
};

var produto = {
	listar: function() {
		$("tbody").empty();
		
		$.get('http://localhost:8080/produto', function(data){
			$.each(data, function(index, value) {
				var row = "<tr><th scope='row'>" + value.id + 
									"</th><th>" + value.nome + 
									"</th><th>" + value.quantidade + 
									"</th><th>" + value.preco + 
									"</th><th>" + 
					"<button type='button' class='btn-update btn btn-primary'>Alterar</button>" + 
					"<button type='button' class='btn-delete btn btn-danger'>Excluir</button></th></tr>";
				
				$("table tbody").append(row);
			});
		});
		
		$(document).on("click", ".btn-update", function(){
			produto.atualizar($(this));
			produto.listar();
		});

		$(document).on("click", ".btn-delete", function(){
			produto.excluir($(this));
			produto.listar();
		});
		
	},
	
	salvar: function() {
		var requestData = `id=${form.id.value}&nome=${form.nome.value.toUpperCase()}&quantidade=${form.quantidade.value}&preco=${form.preco.value}`;
		
		$.post('http://localhost:8080/produto', requestData);
		form.clear();
		
	},
	
	valoresLinha: function(btn) {
		var row = btn.parents("th").siblings();
		
		return $.map(row, function(elemento) {
			return elemento.textContent;
		});
	},
	
	atualizar: function(btn) {
		var produtoSelecionado = this.valoresLinha(btn);
	
		$("#id").val(produtoSelecionado[0]);
		$("#nome").val(produtoSelecionado[1]);
		$("#quantidade").val(produtoSelecionado[2]);
		$("#preco").val(produtoSelecionado[3]);
	},
	
	excluir: function(btn) {
		var produtoSelecionado = this.valoresLinha(btn);
		
		var requestData = `id=${produtoSelecionado[0]}&nome=${produtoSelecionado[1]}&quantidade=${produtoSelecionado[2]}&preco=${produtoSelecionado[3]}`;
		
		$.ajax({
			url: 'http://localhost:8080/produto',
			type: "delete",
			data: requestData
		});
		
	}
};

$(document).ready(function() {
	produto.listar();
	
});

$(document).on("click", "#btn-submit", function(){
	produto.salvar();
	produto.listar();
});

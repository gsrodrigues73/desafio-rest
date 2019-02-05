package br.com.gilberto.produtos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gilberto.produtos.model.Produto;
import br.com.gilberto.produtos.repository.ProdutoRepository;

@RestController
@RequestMapping("/venda")
public class TransacaoResource {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping("/{id}/{qtdVenda}")
	public Produto vendaProduto(@PathVariable("id") Long id, @PathVariable("qtdVenda") int qtdVenda) {
		Produto produto = produtoRepository.findById(id).get();
		produto.venda(qtdVenda);
		return produtoRepository.save(produto);
		
	}

}

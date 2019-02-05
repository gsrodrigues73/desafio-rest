package br.com.gilberto.produtos.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gilberto.produtos.model.Produto;
import br.com.gilberto.produtos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping()
	public @ResponseBody Iterable<Produto> listaProdutos() {
		Iterable<Produto> listaProdutos = produtoRepository.findAll();
		return listaProdutos;
		
	}
	
	@PostMapping()
	public Produto salvaProduto(@Valid Produto produto) {
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping()
	public Produto excluiProduto(Produto produto) {
		produtoRepository.delete(produto);
		return produto;
		
	}
	
}

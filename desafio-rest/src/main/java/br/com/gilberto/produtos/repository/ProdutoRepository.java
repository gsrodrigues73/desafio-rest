package br.com.gilberto.produtos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gilberto.produtos.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}

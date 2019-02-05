package br.com.gilberto.produtos.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco;
	
	public Produto() {
		super();
	}

	public Produto(String nome, int quantidade, BigDecimal preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}

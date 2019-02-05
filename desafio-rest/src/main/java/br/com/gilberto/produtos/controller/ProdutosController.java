package br.com.gilberto.produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutosController {
	
	@GetMapping("/produtos")
	public String novo() {
		return "cadastro-produto";
	}
}

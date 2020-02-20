package com.brq.spring.cursomc.controllers;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brq.spring.cursomc.domain.Produto;
import com.brq.spring.cursomc.dto.ProdutoDto;
import com.brq.spring.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDto> find(@PathVariable Integer id){
		
		Produto produto = service.buscar(id);
		
		ProdutoDto produtoDto = ProdutoDto.builder()
									.id(produto.getId())
									.nome(produto.getNome())
									.preco(produto.getPreco())
									.build();
		
		return ResponseEntity.ok(produtoDto);
		
	}

	
	@PostMapping(value = "/insere-produto")
	public ResponseEntity<Void> insert(@RequestBody Produto obj ){
				
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}

	
	
	
	
}


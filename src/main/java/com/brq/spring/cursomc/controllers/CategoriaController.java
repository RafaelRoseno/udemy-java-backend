package com.brq.spring.cursomc.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brq.spring.cursomc.domain.Categoria;
//import com.brq.spring.cursomc.dto.CategoriaDto;
import com.brq.spring.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		//categoriaDto no diamante
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping(value = "/post")
	public ResponseEntity<Void> insert(@RequestBody Categoria obj ){
				
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update (@RequestBody Categoria obj, @PathVariable Integer id ){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
//  GetMapping
//	CategoriaDto categoriaDto = CategoriaDto.builder()
//									.id(obj.getId())
//									.nome(obj.getNome())
//									.build();
	
}

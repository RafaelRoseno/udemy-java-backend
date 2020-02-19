package com.brq.spring.cursomc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.spring.cursomc.domain.Categoria;
import com.brq.spring.cursomc.dto.CategoriaDto;
import com.brq.spring.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CategoriaDto> find(@PathVariable Integer id){
		Categoria obj = service.buscar(id);
		
		CategoriaDto categoriaDto = CategoriaDto.builder()
										.id(obj.getId())
										.nome(obj.getNome())
										.build();
		
		return ResponseEntity.ok().body(categoriaDto);
			
	}
}

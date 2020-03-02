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

import com.brq.spring.cursomc.domain.Estado;
//import com.brq.spring.cursomc.dto.EstadoDto;
import com.brq.spring.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
//		public ResponseEntity<EstadoDto> find(@PathVariable Integer id){
		
		Estado estado = estadoService.find(id);
		
//		EstadoDto estadoDto = EstadoDto.builder()
//										.nome(estado.getNome())
//										.id(estado.getId())
//										.build();
		
		return ResponseEntity.ok(estado);
				
		}
	
	@PostMapping(value = "/insere")
	public ResponseEntity<Void> insert(@RequestBody Estado obj ){
				
		obj = estadoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();	
	}
	
}

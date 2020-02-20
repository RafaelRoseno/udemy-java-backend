package com.brq.spring.cursomc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.spring.cursomc.domain.Estado;
import com.brq.spring.cursomc.dto.EstadoDto;
import com.brq.spring.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EstadoDto> find(@PathVariable Integer id){
		
		Estado estado = estadoService.find(id);
		
		EstadoDto estadoDto = EstadoDto.builder()
										.nome(estado.getNome())
										.id(estado.getId())
										.build();
		
		return ResponseEntity.ok(estadoDto);
				
		}
	
}

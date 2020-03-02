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

import com.brq.spring.cursomc.domain.Pedido;
//import com.brq.spring.cursomc.dto.PedidoDto;
import com.brq.spring.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		//categoriaDto no diamante
		Pedido obj = service.find(id);
		
//		PedidoDto categoriaDto = PedidoDto.builder()
//										.id(obj.getId())
//										.nome(obj.getNome())
//										.build();
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping(value = "/insere")
	public ResponseEntity<Void> insert(@RequestBody Pedido obj ){
				
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();	
	}
}

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

import com.brq.spring.cursomc.domain.Cidade;
import com.brq.spring.cursomc.dto.CidadeDto;
import com.brq.spring.cursomc.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CidadeDto> find(@PathVariable Integer id){
		
		Cidade cidade = cidadeService.find(id);
		
		CidadeDto cidadeDto = CidadeDto.builder()
								.nome(cidade.getNome())
								.id(cidade.getId())
								.build();
		
		return ResponseEntity.ok(cidadeDto);
	}
	
	@PostMapping(value = "/insere-cidade")
	public ResponseEntity<Void> insert(@RequestBody Cidade obj ){
				
		obj = cidadeService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
	
}


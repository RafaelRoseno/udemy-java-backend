package com.brq.spring.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.spring.cursomc.domain.Cliente;
import com.brq.spring.cursomc.repository.ClienteRepository;
import com.brq.spring.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto " + id + " deu ruim! "
				+ ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente insert(Cliente obj) {
	    obj.setId(null);
	    return repo.save(obj);
	}
	
}

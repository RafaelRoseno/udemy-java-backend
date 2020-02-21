package com.brq.spring.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.spring.cursomc.domain.Estado;
import com.brq.spring.cursomc.repository.EstadoRepository;
import com.brq.spring.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado find(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto " + id + " deu ruim!"
				+ ", Tipo: " + Estado.class.getName()));
	}
	
	public Estado insert(Estado obj) {
	    obj.setId(null);
	    return estadoRepository.save(obj);
 }
	
}

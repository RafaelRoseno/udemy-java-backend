package com.brq.spring.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.spring.cursomc.domain.Pedido;
import com.brq.spring.cursomc.repository.PedidoRepository;
import com.brq.spring.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto " + id + " deu ruim! "
				+ ", Tipo: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
	    obj.setId(null);
	    return repo.save(obj);
	}
	
}

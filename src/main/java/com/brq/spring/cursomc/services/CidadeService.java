package com.brq.spring.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.spring.cursomc.domain.Cidade;
import com.brq.spring.cursomc.repository.CidadeRepository;
import com.brq.spring.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
		public Cidade find(Integer id) {
			Optional<Cidade> obj = cidadeRepository.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto " + id + " deu ruim!"
					+ ", Tipo: " + Cidade.class.getName()));
		}
		
		public Cidade insert(Cidade obj) {
		    obj.setId(null);
		    return cidadeRepository.save(obj);
	 }
	
}

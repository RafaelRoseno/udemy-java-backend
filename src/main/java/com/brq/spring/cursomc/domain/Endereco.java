package com.brq.spring.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity(name= "Endereco")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Endereco  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String logradouro;
	String numero;
	String complemento;
	String bairro;
	String cep;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	Cidade cidade;
	

	public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep,
			Cliente cliente, Cidade cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}
	
	
	
}

package com.brq.spring.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.brq.spring.cursomc.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Cliente")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cliente  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nome;
	String email;
	String cpfOuCnpj;
	TipoCliente tipo;
	
	@JsonManagedReference
	@Builder.Default
	@OneToMany(mappedBy = "cliente")
	List<Endereco> enderecos = new ArrayList<>();
	
	@Builder.Default
	@ElementCollection
	@CollectionTable(name="telefone")
	Set<String> telefone = new HashSet<>();
	
	@Builder.Default
	@OneToMany(mappedBy = "cliente")
	List<Pedido> pedidos = new ArrayList<>();


	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
	}
	
	
	
	public void setTipo(TipoCliente tipo) {
		this.tipo=tipo;
	}
	
	
	
}

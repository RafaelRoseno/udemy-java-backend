package com.brq.spring.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	Date instante;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
	Endereco enderecoEntrega;
	
	@OneToMany(mappedBy = "id.pedido")
	@Builder.Default
	Set<ItemPedido> itens = new HashSet<>();
	

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
	}
	
	
	

}

package com.brq.spring.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.brq.spring.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	Integer id;
	Integer estadoPagamento;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name="pedido_id")
	@MapsId
	Pedido pedido;
	
	Cliente cliente;
	Endereco endereco;
	

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estado.getCod();
		this.pedido = pedido;
	}
	
	public void setTipo(EstadoPagamento estadoPagamento) {
		this.estadoPagamento=estadoPagamento.getCod();
	}
	
	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}
	
	
	
}

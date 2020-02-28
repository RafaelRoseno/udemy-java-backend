package com.brq.spring.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.brq.spring.cursomc.domain.enums.EstadoPagamento;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagamentoComCartao extends Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	Integer numeroDeParcelas;
	
	@Builder
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Cliente cliente, Endereco endereco,
			Integer numeroParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroParcelas;
	}
	
	
}

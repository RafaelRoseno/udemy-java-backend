package com.brq.spring.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "Cidades")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String nome;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="estado_id")
	Estado estado;
		
}

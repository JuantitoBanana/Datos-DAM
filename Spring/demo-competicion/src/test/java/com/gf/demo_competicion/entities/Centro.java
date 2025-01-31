package com.gf.demo_competicion.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Centro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centro_id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "contacto")
	private Integer contacto;
	
	@OneToMany
	@JoinColumn(name = "centro_id")
	private Set<Participante> participantes =  new HashSet<Participante>();
}

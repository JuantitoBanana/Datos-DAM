package com.gf.demo_competicion.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modalidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long modalidad_id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "codigo")
	private String codigo;
	
	@OneToMany
	@JoinColumn(name = "modalidad_id")
	private Set<Participante> participantes =  new HashSet<Participante>();
	
	@ManyToMany
	private Set<Premio> premios =  new HashSet<Premio>();
}

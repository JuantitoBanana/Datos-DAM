package com.gf.demo_competicion.entities;

import java.time.LocalDate;
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
@Table(name = "competiciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competicion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long competicion_id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "anio")
	private Integer anio;
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@OneToMany
	@JoinColumn(name = "competicion_id")
	private Set<Centro> centros =  new HashSet<Centro>();
}

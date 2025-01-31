package com.gf.demo_mercantil.entities;

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
@Table(name = "sociedades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sociedad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sociedad_id;
	@Column(name = "cif")
 	private String cif;
	@Column(name = "nombre")
 	private String nombre;
	@Column(name = "tipo")
 	private String tipo;
	@Column(name = "capital")
 	private Double capital;
	
	@OneToMany
	@JoinColumn(name = "sociedad_id")
	private Set<Socio> socios =  new HashSet<Socio>();
}

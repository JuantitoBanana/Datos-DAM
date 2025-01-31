package com.gf.demo_competicion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "premios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Premio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long premio_id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "cuantia")
	private Double cuantia;
}

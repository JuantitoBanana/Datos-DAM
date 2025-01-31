package com.gf.demo_mercantil.entities;

import java.time.LocalDate;

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
@Table(name = "participaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long participacion_id;
	@Column(name = "valor")
	private Double valor;
	@Column(name = "fecha")
	private LocalDate fecha;
}

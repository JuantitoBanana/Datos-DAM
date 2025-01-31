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
@Table(name = "lotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lote_id;
	@Column(name = "participacionesTotal")
	private Integer participacionesTotal;
	@Column(name = "porcentajeCapital")
	private Double porcentajeCapital;
	
	@OneToMany
	@JoinColumn(name = "lote_id")
	private Set<Participacion> participaciones =  new HashSet<Participacion>();
}

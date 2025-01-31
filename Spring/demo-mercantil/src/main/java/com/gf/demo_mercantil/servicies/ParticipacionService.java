package com.gf.demo_mercantil.servicies;

import java.util.List;

import com.gf.demo_mercantil.entities.Participacion;

public interface ParticipacionService {
	
	List<Participacion> findAll();
	
	Participacion findById(Long id);
	
	void save (Participacion participacion);
	
	void update (Long id);
	
	void delete(Long id);
}

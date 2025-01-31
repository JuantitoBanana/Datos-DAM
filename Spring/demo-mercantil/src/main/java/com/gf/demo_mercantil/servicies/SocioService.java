package com.gf.demo_mercantil.servicies;

import java.util.List;

import com.gf.demo_mercantil.entities.Socio;

public interface SocioService {

	List<Socio> findAll();
	
	Socio findById(Long id);
	
	void save (Socio socio);
	
	void update (Long id);
	
	void delete(Long id);
}

package com.gf.demo_mercantil.servicies;

import java.util.List;

import com.gf.demo_mercantil.entities.Sociedad;

public interface SociedadService {

	List<Sociedad> findAll();
	
	Sociedad findById(Long id);
	
	void save (Sociedad sociedad);
	
	void update (Long id);
	
	void delete(Long id);
}

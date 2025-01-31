package com.gf.demo_mercantil.servicies;

import java.util.List;

import com.gf.demo_mercantil.entities.Lote;

public interface LoteService {
	
	List<Lote> findAll();
	
	Lote findById(Long id);
	
	void save (Lote lote);
	
	void update (Long id);
	
	void delete(Long id);
}

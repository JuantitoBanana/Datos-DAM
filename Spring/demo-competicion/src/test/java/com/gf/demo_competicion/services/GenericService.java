package com.gf.demo_competicion.services;

import java.util.List;

public interface GenericService <T>{
	
	List<T> findAll();
	
	T findById(Long id);
	
	void save(T t);
	
	void update(Long id, T t);
	
	void delete(Long id);
}

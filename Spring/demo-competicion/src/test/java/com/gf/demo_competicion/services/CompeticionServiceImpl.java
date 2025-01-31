package com.gf.demo_competicion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_competicion.entities.Competicion;
import com.gf.demo_competicion.repositories.CompeticionRepository;

@Service
public class CompeticionServiceImpl<T> implements GenericService<T>{

	@Autowired
	CompeticionRepository competicionRepository;
	
	@Override
	public List<T> findAll() {
		return (List<T>) competicionRepository.findAll();
	}

	@Override
	public T findById(Long id) {
		Optional<Competicion> resultCompeticion = competicionRepository.findById(id);
		Competicion competicion =  null;
		if(resultCompeticion.isPresent()) {
			competicion = resultCompeticion.get();
		}
		return (T) competicion;
	}

	@Override
	public void save(T t) {
		competicionRepository.save((Competicion) t);
		
	}

	@Override
	public void update(Long id, T t) {
		Competicion competicion = (Competicion) findById(id);
		competicion = (Competicion)t;
		competicionRepository.save(competicion);
		
	}

	@Override
	public void delete(Long id) {
		competicionRepository.deleteById(id);	
	}
	
}

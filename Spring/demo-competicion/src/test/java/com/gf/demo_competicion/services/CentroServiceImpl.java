package com.gf.demo_competicion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_competicion.entities.Centro;
import com.gf.demo_competicion.repositories.CentroRepository;

@Service
public class CentroServiceImpl<T> implements GenericService<T>{
	
	@Autowired
	CentroRepository centroRepository;
	
	@Override
	public List<T> findAll() {
		return (List<T>) centroRepository.findAll();
	}

	@Override
	public T findById(Long id) {
		Optional<Centro> resultCentro = centroRepository.findById(id);
		Centro centro =  null;
		if(resultCentro.isPresent()) {
			centro = resultCentro.get();
		}
		return (T) centro;
	}

	@Override
	public void save(T t) {
		centroRepository.save((Centro) t);
		
	}

	@Override
	public void update(Long id, T t) {
		Centro centro = (Centro) findById(id);
		centro = (Centro)t;
		centroRepository.save(centro);
		
	}

	@Override
	public void delete(Long id) {
		centroRepository.deleteById(id);	
	}
}

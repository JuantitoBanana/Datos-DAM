package com.gf.demo_competicion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_competicion.entities.Premio;
import com.gf.demo_competicion.repositories.PremioRepository;


@Service
public class PremioServiceImpl<T> implements GenericService<T>{

	@Autowired
	PremioRepository premioRepository;
	
	@Override
	public List<T> findAll() {
		return (List<T>) premioRepository.findAll();
	}

	@Override
	public T findById(Long id) {
		Optional<Premio> resultPremio = premioRepository.findById(id);
		Premio premio =  null;
		if(resultPremio.isPresent()) {
			premio = resultPremio.get();
		}
		return (T) premio;
	}

	@Override
	public void save(T t) {
		premioRepository.save((Premio) t);
		
	}

	@Override
	public void update(Long id, T t) {
		Premio premio = (Premio) findById(id);
		premio = (Premio)t;
		premioRepository.save(premio);
		
	}

	@Override
	public void delete(Long id) {
		premioRepository.deleteById(id);	
	}
}

package com.gf.demo_competicion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_competicion.entities.Modalidad;
import com.gf.demo_competicion.repositories.ModalidadRepository;



@Service
public class ModalidadServiceImpl<T> implements GenericService<T>{
	
	@Autowired
	ModalidadRepository modalidadRepository;
	
	@Override
	public List<T> findAll() {
		return (List<T>) modalidadRepository.findAll();
	}

	@Override
	public T findById(Long id) {
		Optional<Modalidad> resultModalidad = modalidadRepository.findById(id);
		Modalidad modalidad =  null;
		if(resultModalidad.isPresent()) {
			modalidad = resultModalidad.get();
		}
		return (T) modalidad;
	}

	@Override
	public void save(T t) {
		modalidadRepository.save((Modalidad) t);
		
	}

	@Override
	public void update(Long id, T t) {
		Modalidad modalidad = (Modalidad) findById(id);
		modalidad = (Modalidad)t;
		modalidadRepository.save(modalidad);
		
	}

	@Override
	public void delete(Long id) {
		modalidadRepository.deleteById(id);	
	}
}

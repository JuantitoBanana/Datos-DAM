package com.gf.demo_competicion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_competicion.entities.Tutor;
import com.gf.demo_competicion.repositories.TutorRepository;

@Service
public class TutorServiceImpl<T> implements GenericService<T>{

	@Autowired
	TutorRepository tutorRepository;
	
	@Override
	public List<T> findAll() {
		return (List<T>) tutorRepository.findAll();
	}

	@Override
	public T findById(Long id) {
		Optional<Tutor> resultTutor = tutorRepository.findById(id);
		Tutor tutor =  null;
		if(resultTutor.isPresent()) {
			tutor = resultTutor.get();
		}
		return (T) tutor;
	}

	@Override
	public void save(T t) {
		tutorRepository.save((Tutor) t);
		
	}

	@Override
	public void update(Long id, T t) {
		Tutor tutor = (Tutor) findById(id);
		tutor = (Tutor)t;
		tutorRepository.save(tutor);
		
	}

	@Override
	public void delete(Long id) {
		tutorRepository.deleteById(id);	
	}
}

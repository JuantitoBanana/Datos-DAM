package com.gf.demo_competicion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_competicion.entities.Participante;
import com.gf.demo_competicion.repositories.ParticipanteRepository;

@Service
public class ParticipanteServiceImpl<T> implements GenericService<T>{

	@Autowired
	ParticipanteRepository participanteRepository;
	
	@Override
	public List<T> findAll() {
		return (List<T>) participanteRepository.findAll();
	}

	@Override
	public T findById(Long id) {
		Optional<Participante> resultParticipante = participanteRepository.findById(id);
		Participante participante =  null;
		if(resultParticipante.isPresent()) {
			participante = resultParticipante.get();
		}
		return (T) participante;
	}

	@Override
	public void save(T t) {
		participanteRepository.save((Participante) t);
		
	}

	@Override
	public void update(Long id, T t) {
		Participante participante = (Participante) findById(id);
		participante = (Participante)t;
		participanteRepository.save(participante);
		
	}

	@Override
	public void delete(Long id) {
		participanteRepository.deleteById(id);	
	}
}

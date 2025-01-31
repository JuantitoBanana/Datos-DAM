package com.gf.demo_mercantil.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_mercantil.entities.Participacion;
import com.gf.demo_mercantil.repositories.ParticipacionRepository;


@Service
public class ParticipacionServiceImpl implements ParticipacionService{

	@Autowired
	private ParticipacionRepository participacionRepository;
	
	@Override
	public List<Participacion> findAll() {
		// TODO Auto-generated method stub
		return participacionRepository.findAll();
	}

	@Override
	public Participacion findById(Long id) {
		Optional<Participacion> resultParticipacion = participacionRepository.findById(id);
		Participacion participacion = null;
		if(resultParticipacion.isPresent()) {
			participacion =  resultParticipacion.get();
		}
		return participacion;
	}

	@Override
	public void save(Participacion participacion) {
		participacionRepository.save(participacion);
		
	}

	@Override
	public void update(Long id) {
		participacionRepository.save(findById(id));
		
	}

	@Override
	public void delete(Long id) {
		participacionRepository.deleteById(id);
		
	}
}

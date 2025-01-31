package com.gf.demo_mercantil.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_mercantil.entities.Sociedad;
import com.gf.demo_mercantil.repositories.SociedadRepository;

@Service
public class SociedadServiceImpl implements SociedadService{

	@Autowired
	private SociedadRepository sociedadRepository;
	
	@Override
	public List<Sociedad> findAll() {
		// TODO Auto-generated method stub
		return sociedadRepository.findAll();
	}

	@Override
	public Sociedad findById(Long id) {
		Optional<Sociedad> resultSociedad = sociedadRepository.findById(id);
		Sociedad sociedad = null;
		if(resultSociedad.isPresent()) {
			sociedad =  resultSociedad.get();
		}
		return sociedad;
	}

	@Override
	public void save(Sociedad sociedad) {
		sociedadRepository.save(sociedad);
		
	}

	@Override
	public void update(Long id) {
		sociedadRepository.save(findById(id));
		
	}

	@Override
	public void delete(Long id) {
		sociedadRepository.deleteById(id);
		
	}

	
}

package com.gf.demo_mercantil.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_mercantil.entities.Socio;
import com.gf.demo_mercantil.repositories.SocioRepository;

@Service
public class SocioServiceImpl implements SocioService{

	@Autowired
	private SocioRepository socioRepository;
	
	@Override
	public List<Socio> findAll() {
		// TODO Auto-generated method stub
		return socioRepository.findAll();
	}

	@Override
	public Socio findById(Long id) {
		Optional<Socio> resultSocio = socioRepository.findById(id);
		Socio socio = null;
		if(resultSocio.isPresent()) {
			socio =  resultSocio.get();
		}
		return socio;
	}

	@Override
	public void save(Socio socio) {
		socioRepository.save(socio);
		
	}

	@Override
	public void update(Long id) {
		socioRepository.save(findById(id));
		
	}

	@Override
	public void delete(Long id) {
		socioRepository.deleteById(id);
		
	}
}

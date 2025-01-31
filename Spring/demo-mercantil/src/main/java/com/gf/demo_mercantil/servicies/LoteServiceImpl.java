package com.gf.demo_mercantil.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo_mercantil.entities.Lote;
import com.gf.demo_mercantil.repositories.LoteRepository;

@Service
public class LoteServiceImpl implements LoteService{

	@Autowired
	private LoteRepository loteRepository;
	
	@Override
	public List<Lote> findAll() {
		// TODO Auto-generated method stub
		return loteRepository.findAll();
	}

	@Override
	public Lote findById(Long id) {
		Optional<Lote> resultLote = loteRepository.findById(id);
		Lote lote = null;
		if(resultLote.isPresent()) {
			lote =  resultLote.get();
		}
		return lote;
	}

	@Override
	public void save(Lote lote) {
		loteRepository.save(lote);
		
	}

	@Override
	public void update(Long id) {
		loteRepository.save(findById(id));
		
	}

	@Override
	public void delete(Long id) {
		loteRepository.deleteById(id);
		
	}
}

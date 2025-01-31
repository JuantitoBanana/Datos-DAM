package com.gf.demo_competicion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo_competicion.entities.Participante;
import com.gf.demo_competicion.services.GenericService;

@RestController
public class ParticipanteController<T> {

	@Autowired
	GenericService<T> participante;
	
	@GetMapping("/participantes")
	public List<Participante> getAll(){
		return (List<Participante>) participante.findAll();
	}
	
	@GetMapping("/participante/{id}")
	public Participante findById(@PathVariable() Long Id) {
		return (Participante) participante.findById(Id);
	}
	
	@PostMapping("/participante")
	public void insert(Participante p) {
		participante.save((T) p);
	}
	
	@PutMapping("/participante/{id}")
	public void update(@PathVariable() Long id,@RequestBody Participante p) {
		participante.update(id, (T) p);
	}
	
	@DeleteMapping("/participante/{id}")
	public void delete(@PathVariable() Long id) {
		participante.delete(id);
	}
}

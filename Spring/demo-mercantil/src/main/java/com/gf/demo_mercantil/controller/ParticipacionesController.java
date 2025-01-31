package com.gf.demo_mercantil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo_mercantil.entities.Participacion;
import com.gf.demo_mercantil.servicies.ParticipacionService;

@RestController
public class ParticipacionesController {

	@Autowired
	ParticipacionService participacion;
	
	@GetMapping("/participaciones")
	public List<Participacion> getAll(){
		return (List<Participacion>) participacion.findAll();
	}
	
	
	public Participacion findById(Long id) {
		return participacion.findById(id);
	}
	
	@PostMapping("/participacion")
	public void create(@RequestBody Participacion p) {
		participacion.save(p);
	}
	
	public void update(Long id) {
		participacion.save(participacion.findById(id));
	}
	
	@DeleteMapping("/participacion/{id}")
	public void delete(@PathVariable() Long id) {
		participacion.delete(id);
	}
}

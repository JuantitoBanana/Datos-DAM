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

import com.gf.demo_competicion.entities.Modalidad;
import com.gf.demo_competicion.services.GenericService;

@RestController
public class ModalidadController<T> {
	
	@Autowired
	GenericService<T> modalidad;
	
	@GetMapping("/modalidades")
	public List<Modalidad> getAll(){
		return (List<Modalidad>) modalidad.findAll();
	}
	
	@GetMapping("/modalidad/{id}")
	public Modalidad findById(@PathVariable() Long Id) {
		return (Modalidad) modalidad.findById(Id);
	}
	
	@PostMapping("/modalidad")
	public void insert(Modalidad m) {
		modalidad.save((T) m);
	}
	
	@PutMapping("/modalidad/{id}")
	public void update(@PathVariable() Long id,@RequestBody Modalidad m) {
		modalidad.update(id, (T) m);
	}
	
	@DeleteMapping("/modalidad/{id}")
	public void delete(@PathVariable() Long id) {
		modalidad.delete(id);
	}
}

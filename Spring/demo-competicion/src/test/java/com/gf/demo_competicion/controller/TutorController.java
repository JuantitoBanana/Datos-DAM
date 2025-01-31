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

import com.gf.demo_competicion.entities.Tutor;
import com.gf.demo_competicion.services.GenericService;

@RestController
public class TutorController<T> {

	@Autowired
	GenericService<T> tutor;
	
	@GetMapping("/tutores")
	public List<Tutor> getAll(){
		return (List<Tutor>) tutor.findAll();
	}
	
	@GetMapping("/tutor/{id}")
	public Tutor findById(@PathVariable() Long Id) {
		return (Tutor) tutor.findById(Id);
	}
	
	@PostMapping("/tutor")
	public void insert(Tutor t) {
		tutor.save((T) t);
	}
	
	@PutMapping("/tutor/{id}")
	public void update(@PathVariable() Long id,@RequestBody Tutor t) {
		tutor.update(id, (T) t);
	}
	
	@DeleteMapping("/tutor/{id}")
	public void delete(@PathVariable() Long id) {
		tutor.delete(id);
	}
}

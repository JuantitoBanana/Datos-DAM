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

import com.gf.demo_competicion.entities.Competicion;
import com.gf.demo_competicion.services.GenericService;

@RestController
public class CompeticionController<T> {

	@Autowired
	GenericService<T> competicion;
	
	@GetMapping("/competiciones")
	public List<Competicion> getAll(){
		return (List<Competicion>) competicion.findAll();
	}
	
	@GetMapping("/competicion/{id}")
	public Competicion findById(@PathVariable() Long Id) {
		return (Competicion) competicion.findById(Id);
	}
	
	@PostMapping("/competicion")
	public void insert(Competicion c) {
		competicion.save((T) c);
	}
	
	@PutMapping("/competicion/{id}")
	public void update(@PathVariable() Long id,@RequestBody Competicion c) {
		competicion.update(id, (T) c);
	}
	
	@DeleteMapping("/competicion/{id}")
	public void delete(@PathVariable() Long id) {
		competicion.delete(id);
	}
}

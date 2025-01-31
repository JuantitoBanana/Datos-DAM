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

import com.gf.demo_competicion.entities.Centro;
import com.gf.demo_competicion.services.GenericService;

@RestController
public class CentroController<T> {

	@Autowired
	GenericService<T> centro;
	
	@GetMapping("/centros")
	public List<Centro> getAll(){
		return (List<Centro>) centro.findAll();
	}
	
	@GetMapping("/centro/{id}")
	public Centro findById(@PathVariable() Long Id) {
		return (Centro) centro.findById(Id);
	}
	
	@PostMapping("/centro")
	public void insert(Centro c) {
		centro.save((T) c);
	}
	
	@PutMapping("/centro/{id}")
	public void update(@PathVariable() Long id,@RequestBody Centro c) {
		centro.update(id, (T) c);
	}
	
	@DeleteMapping("/centro/{id}")
	public void delete(@PathVariable() Long id) {
		centro.delete(id);
	}
}

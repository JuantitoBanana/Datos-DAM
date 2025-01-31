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

import com.gf.demo_competicion.entities.Premio;
import com.gf.demo_competicion.services.GenericService;

@RestController
public class PremioController<T> {

	@Autowired
	GenericService<T> premio;
	
	@GetMapping("/premios")
	public List<Premio> getAll(){
		return (List<Premio>) premio.findAll();
	}
	
	@GetMapping("/premio/{id}")
	public Premio findById(@PathVariable() Long Id) {
		return (Premio) premio.findById(Id);
	}
	
	@PostMapping("/premio")
	public void insert(Premio p) {
		premio.save((T) p);
	}
	
	@PutMapping("/premio/{id}")
	public void update(@PathVariable() Long id,@RequestBody Premio p) {
		premio.update(id, (T) p);
	}
	
	@DeleteMapping("/premio/{id}")
	public void delete(@PathVariable() Long id) {
		premio.delete(id);
	}
}

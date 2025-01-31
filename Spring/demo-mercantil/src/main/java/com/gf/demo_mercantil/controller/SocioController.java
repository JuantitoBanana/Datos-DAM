package com.gf.demo_mercantil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo_mercantil.entities.Socio;
import com.gf.demo_mercantil.servicies.SocioService;

@RestController
public class SocioController {
	
	@Autowired
	SocioService socio;
	
	@GetMapping("/socios")
	public List<Socio> getAll(){
		return (List<Socio>) socio.findAll();
	}
	
	@GetMapping("/socio/{id}")
	public Socio findById(@PathVariable() Long id) {
		return socio.findById(id);
	}
	
	@PostMapping("/socio")
	public void create(@RequestBody Socio s) {
		socio.save(s);
	}
	
	@PostMapping("/socio/{id}")
	public void update(@RequestBody Long id) {
		socio.save(socio.findById(id));
	}
	
	@DeleteMapping("/socio/{id}")
	public void delete(@PathVariable() Long id) {
		socio.delete(id);
	}
}

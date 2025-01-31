package com.gf.demo_mercantil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo_mercantil.entities.Sociedad;
import com.gf.demo_mercantil.servicies.SociedadService;

@RestController
public class SociedadController {

	@Autowired
	SociedadService sociedad;
	
	@GetMapping("/sociedades")
	public List<Sociedad> getAll(){
		return (List<Sociedad>) sociedad.findAll();
	}
	
	public Sociedad findById(Long id) {
		return sociedad.findById(id);
	}
	
	@PostMapping("/sociedad")
	public void create(@RequestBody Sociedad s) {
		sociedad.save(s);
	}
	
	public void update(Long id) {
		sociedad.save(sociedad.findById(id));
	}
	
	public void delete(Long id) {
		sociedad.delete(id);
	}
}

package com.gf.demo_mercantil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo_mercantil.entities.Lote;
import com.gf.demo_mercantil.servicies.LoteService;

@RestController
public class LoteController {

	@Autowired
	LoteService lote;
	
	@GetMapping("/lotes")
	public List<Lote> getAll(){
		return (List<Lote>) lote.findAll();
	}
	
	@GetMapping("/lote/{id}")
	public Lote findById(@PathVariable() Long id) {
		return lote.findById(id);
	}
	
	@PostMapping("/lote")
	public void create(@RequestBody Lote l) {
		lote.save(l);
	}
	
	public void update(Long id) {
		lote.save(lote.findById(id));
	}
	
	public void delete(Long id) {
		lote.delete(id);
	}
}

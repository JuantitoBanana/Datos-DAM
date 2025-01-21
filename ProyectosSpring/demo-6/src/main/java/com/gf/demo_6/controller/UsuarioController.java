package com.gf.demo_6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo_6.entities.Usuario;
import com.gf.demo_6.services.UsuarioService;


@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuario;
	
	@GetMapping("/usuarios")
	public List<Usuario> getAll(){
		return (List<Usuario>) usuario.findAll();
	}
	
	@PostMapping("/insert")
	public void create(@RequestBody Usuario user) {
		usuario.save(user);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Usuario user) {
		usuario.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable() Long id) {
		usuario.delete(usuario.findById(id));
	}
}

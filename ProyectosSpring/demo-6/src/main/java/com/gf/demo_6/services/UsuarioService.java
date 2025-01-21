package com.gf.demo_6.services;

import java.util.List;

import com.gf.demo_6.entities.Usuario;

public interface UsuarioService {
	List<Usuario> findAll();
	
	void save(Usuario server);
	
	Usuario findById(Long id);
	
	void delete(Usuario user);
}

package com.gf.demo_6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gf.demo_6.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

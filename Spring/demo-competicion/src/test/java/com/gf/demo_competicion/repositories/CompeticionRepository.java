package com.gf.demo_competicion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gf.demo_competicion.entities.Competicion;

public interface CompeticionRepository extends JpaRepository<Competicion, Long>{

}

package com.gf.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaControlador {
	
	@GetMapping({"/", "/Hola"})
	public String mostrarPaginas() {
		
		return "Hola";
	}
}

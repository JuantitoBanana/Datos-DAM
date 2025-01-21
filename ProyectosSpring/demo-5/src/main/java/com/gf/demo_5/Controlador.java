package com.gf.demo_5;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
	
	@GetMapping(value="/index", produces = MediaType.TEXT_PLAIN_VALUE)
	public String index() {
		return "HOLA MUNDO SPRING";
	}
}

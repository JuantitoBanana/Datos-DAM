package com.gf.demo_ThemeLeaf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping({"/index", "/hola_mundo"})
	public ArrayList<String> mostrarPaginas(Model model) {
		Persona p1 = new Persona("Juan", "Diaz", "21");
		Persona p2 = new Persona("Juan", "Diaz", "21");
		Persona p3 = new Persona("Juan", "Diaz", "21");
		List<Persona> personas = Arrays.asList(p1, p2, p3);
		model.addAttribute("personas", personas);
		ArrayList<String> listaPaginas = new ArrayList<String>();
		listaPaginas.add("index");
		listaPaginas.add("hola_mundo");
		return listaPaginas;
		
	}
}

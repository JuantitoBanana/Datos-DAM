package com.gf.demoJar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HolaController {
	
	@GetMapping("/index")
	public String viewPage (HttpServletRequest request) {
		request.setAttribute("nombre", "Juan");
		request.setAttribute("grupo", "2ºDAM");
		return "index";
	}
	
}

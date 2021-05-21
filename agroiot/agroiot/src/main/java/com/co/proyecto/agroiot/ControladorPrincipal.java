package com.co.proyecto.agroiot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
	@GetMapping("/")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/humedad")
	public String humedad() {
		return "humedad";
	}
	
	@GetMapping("/temperatura")
	public String temperatura() {
		return "temperatura";
	}
	
	@GetMapping("/monitorear")
	public String monitorear() {
		return "monitorear";
	}
}

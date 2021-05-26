package com.co.proyecto.agroiot.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.co.proyecto.agroiot.modelo.Humedad;
import com.co.proyecto.agroiot.modelo.Temperatura;
import com.co.proyecto.agroiot.servicios.ServiciosArduinoInterface;
import com.co.proyecto.agroiot.servicios.ServiciosHumedadInterface;
import com.co.proyecto.agroiot.servicios.ServiciosTemperaturaInterface;

@Controller
public class ControladorPrincipal {
	
	@Autowired
	ServiciosArduinoInterface serviciosArduinoInterface;
	
	@Autowired
	ServiciosHumedadInterface serviciosHumedadInterface;
	
	@Autowired
	ServiciosTemperaturaInterface serviciosTemperaturaInterface;
	
	@GetMapping("/")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/humedad")
	public String humedad(Model model) {
		Iterable<Humedad> humedades = serviciosHumedadInterface.listaHumedades();
		model.addAttribute("humedades", humedades);
		return "humedad";
	}
	
	@GetMapping("/temperatura")
	public String temperatura(Model model) {
		Iterable<Temperatura> temperaturas = serviciosTemperaturaInterface.listaTemperaturas();
		model.addAttribute("temperaturas", temperaturas);
		return "temperatura";
	}
	
	@GetMapping("/monitorear")
	public String monitorearcultivo() {
		return "monitorear";
	}
	
	@GetMapping("/datos/arduino")
	public String monitorear(Model model) {
		List<?> datos= serviciosArduinoInterface.obtenerDatosDesdeArduino();
		model.addAttribute("datos", datos);
		return "monitorear";
	}
}

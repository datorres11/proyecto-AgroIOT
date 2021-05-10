package com.co.proyecto.agroiot.controlador;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.co.proyecto.agroiot.servicios.ServiciosArduinoInterface;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping("/arduino")
public class ArduinoControlador {
	
	@Autowired
	ServiciosArduinoInterface serviciosArduinoInterface;
	
	@GetMapping
	public HashMap<String, String> obtenerDatosDesdeArduino(){
		serviciosArduinoInterface.obtenerDatosDesdeArduino();
		return null;
	}
}

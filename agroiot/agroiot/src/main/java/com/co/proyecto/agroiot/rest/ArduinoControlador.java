package com.co.proyecto.agroiot.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.proyecto.agroiot.servicios.ServiciosArduinoInterface;

@RestController
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

package com.co.proyecto.agroiot.servicios;

import java.util.List;

import com.co.proyecto.agroiot.modelo.Humedad;
import com.co.proyecto.agroiot.modelo.Temperatura;

public interface ServiciosTemperaturaInterface {

	public Temperatura guardarTemperatura(String temperatura);
	
	public List<Temperatura>  listaTemperaturas();
}

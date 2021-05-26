package com.co.proyecto.agroiot.servicios;

import java.util.List;

import com.co.proyecto.agroiot.modelo.Humedad;

public interface ServiciosHumedadInterface {
	
	public Humedad guardarHumedad(String humedad);
	
	public List<Humedad>  listaHumedades();
}
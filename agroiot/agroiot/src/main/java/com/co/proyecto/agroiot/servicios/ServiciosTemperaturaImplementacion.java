package com.co.proyecto.agroiot.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.proyecto.agroiot.dao.RepositorioTemperatura;
import com.co.proyecto.agroiot.modelo.Temperatura;

@Component
public class ServiciosTemperaturaImplementacion implements ServiciosTemperaturaInterface {

	@Autowired
	RepositorioTemperatura repositorioTemperatura;
	
	@Override
	public Temperatura guardarTemperatura(String temperatura) {
		Temperatura temp = new Temperatura();
		temp.setTemperatura(Long.valueOf(temperatura));
		temp.setFecha(new Date());
		return repositorioTemperatura.save(temp);
		
	}

}

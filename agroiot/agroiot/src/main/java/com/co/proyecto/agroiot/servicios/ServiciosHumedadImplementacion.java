package com.co.proyecto.agroiot.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.proyecto.agroiot.dao.RepositorioHumedad;
import com.co.proyecto.agroiot.modelo.Humedad;

@Component
public class ServiciosHumedadImplementacion implements ServiciosHumedadInterface {
	@Autowired
	RepositorioHumedad repositorioHumedad;
	
	@Override
	public Humedad guardarHumedad(String humedad) {
		Humedad humed = new Humedad();
		humed.setHumedad(Long.valueOf(humedad));
		humed.setFecha(new Date());
		return repositorioHumedad.save(humed);
		
	}

}

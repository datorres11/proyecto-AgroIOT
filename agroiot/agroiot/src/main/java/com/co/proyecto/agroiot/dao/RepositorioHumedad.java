package com.co.proyecto.agroiot.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.proyecto.agroiot.modelo.Humedad;

public interface RepositorioHumedad extends CrudRepository<Humedad, Long> {

}

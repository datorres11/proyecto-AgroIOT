package com.co.proyecto.agroiot.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.proyecto.agroiot.modelo.Temperatura;

public interface RepositorioTemperatura extends CrudRepository<Temperatura, Long> {

}

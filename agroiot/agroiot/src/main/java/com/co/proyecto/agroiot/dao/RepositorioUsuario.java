package com.co.proyecto.agroiot.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.proyecto.agroiot.modelo.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

}

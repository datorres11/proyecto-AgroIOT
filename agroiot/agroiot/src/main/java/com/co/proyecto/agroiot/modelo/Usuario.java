package com.co.proyecto.agroiot.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@SequenceGenerator(initialValue = 1,sequenceName = "usuario_id_seq", name = "USUARIO_ID_SEQ",allocationSize = 1)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="USUARIO_ID_SEQ")
	@Column(name="id")
	private int id;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private int telefono;
	
	@OneToMany
	@Column(name="temperatura")
	private List<Temperatura> temperaturas;
	
	@OneToMany
	@Column(name="humedad")
	private List<Temperatura> humedades;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Temperatura> getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(List<Temperatura> temperaturas) {
		this.temperaturas = temperaturas;
	}

	public List<Temperatura> getHumedades() {
		return humedades;
	}

	public void setHumedades(List<Temperatura> humedades) {
		this.humedades = humedades;
	}
}

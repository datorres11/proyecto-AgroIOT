package com.co.proyecto.agroiot.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="humedad")
@SequenceGenerator(initialValue = 1,sequenceName = "humedad_id_seq", name = "HUMEDAD_ID_SEQ",allocationSize = 1)
public class Humedad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="HUMEDAD_ID_SEQ")
	@Column(name="id")
	private int id;
	
	@Column(name="humedad")
	private Long humedad;
	
	@Column(name="fecha")
	private Date fecha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getHumedad() {
		return humedad;
	}

	public void setHumedad(Long humedad) {
		this.humedad = humedad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}

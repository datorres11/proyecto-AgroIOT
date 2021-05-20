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
@Table(name="temperatura")
@SequenceGenerator(initialValue = 1,sequenceName = "temperatura_id_seq", name = "TEMPERATURA_ID_SEQ",allocationSize = 1)
public class Temperatura {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="TEMPERATURA_ID_SEQ")
	@Column(name="id")
	private Long id;
	
	@Column(name="temperatura")
	private Long temperatura;
	
	@Column(name="fecha")
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Long temperatura) {
		this.temperatura = temperatura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

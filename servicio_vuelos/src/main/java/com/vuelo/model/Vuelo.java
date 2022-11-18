package com.vuelo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	private String compañia;	
	private Date fechaVuelo;
	private int plazas;
	
	public Vuelo() {
		super();
	}

	public Vuelo(int idVuelo, String compañia, Date fechaVuelo, int plazas) {
		super();
		this.idVuelo = idVuelo;
		this.compañia = compañia;
		this.fechaVuelo = fechaVuelo;
		this.plazas = plazas;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	
}

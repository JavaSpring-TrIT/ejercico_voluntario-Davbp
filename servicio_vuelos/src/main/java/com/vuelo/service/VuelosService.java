package com.vuelo.service;

import java.util.List;

import com.vuelo.model.Vuelo;


public interface VuelosService {
	List<Vuelo> vuelos(int plazas);	
	void actualizarPlazas(int idVuelo, int plazas);
}

package com.vuelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuelo.dao.VuelosDao;
import com.vuelo.model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {
	@Autowired
	VuelosDao dao;
	
	@Override
	public List<Vuelo> vuelos(int plazas) {
		return dao.findAll().stream().filter(p -> p.getPlazas() >= plazas).toList();
	}

	@Override
	public void actualizarPlazas(int idVuelo, int plazas) {
		Vuelo vuelo =dao.findById(idVuelo).orElse(null);
		if(vuelo!=null) {
			vuelo.setPlazas(vuelo.getPlazas() - plazas);
			dao.save(vuelo);
		}
	}
	

}

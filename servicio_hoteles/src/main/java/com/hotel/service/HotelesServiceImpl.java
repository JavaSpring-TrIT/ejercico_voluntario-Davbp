package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.HotelesDao;
import com.hotel.model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {
	@Autowired
	HotelesDao dao;
	
	@Override
	public List<Hotel> hoteles() {
		return dao.findAll();
	}
	
	@Override
	public Hotel buscarHotel(String nombre) {
		return dao.findByNombre(nombre);
	}


}

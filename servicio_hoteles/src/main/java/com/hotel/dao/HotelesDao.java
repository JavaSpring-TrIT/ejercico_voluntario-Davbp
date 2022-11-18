package com.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer> {
	
	Hotel findByNombre(String nombre);
}

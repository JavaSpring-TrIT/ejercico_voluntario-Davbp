package com.vuelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuelo.model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
	
}

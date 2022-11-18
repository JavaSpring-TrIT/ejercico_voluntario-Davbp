package com.reservas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
	
	List<Reserva> findByIdHotel(int idHotel);
}

package com.reservas.service;

import java.util.List;

import com.reservas.model.Reserva;


public interface ReservasService {
	void altaReserva(Reserva reserva);	
	List<Reserva> obtenerReservas(String hotel);
}

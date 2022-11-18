package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.model.Reserva;
import com.reservas.service.ReservasService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@CrossOrigin("*")
@RestController
public class ReservasController {

	@Value("${eureka.instance.instance-id}")
	String instancia;
	@Autowired
	ReservasService service;
	
	@ApiOperation(value="Realiza una reserva enviando un JSON con sus datos")
	@PostMapping(value="reservar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void reservar(@ApiParam(value="JSON con los datos de la reserva")@RequestBody Reserva reserva) {
		System.out.println("Instancia: " + instancia);
		service.altaReserva(reserva);
	}
	
	@ApiOperation(value="Obtiene las reservas para el hotel indicado")
	@GetMapping(value="reservas/{hotel}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> obtenerReservas(@ApiParam(value="Nombre del hotel")@PathVariable("hotel") String hotel) {
		return service.obtenerReservas(hotel);
	}

}

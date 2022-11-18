package com.vuelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuelo.model.Vuelo;
import com.vuelo.service.VuelosService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@CrossOrigin("*")
@RestController
public class VuelosController {

	@Value("${eureka.instance.instance-id}")
	String instancia;
	@Autowired
	VuelosService service;
	
	@ApiOperation(value="Busca todos los vuelos con plazas suficientes")
	@GetMapping(value="disponibilidadVuelos/{plazas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelosDisponibles(@ApiParam(value="Número de plazas mínimas del vuelo")@PathVariable("plazas") int plazas) {
		System.out.println("Instancia: " + instancia);
		return service.vuelos(plazas);
	}
	
	@ApiOperation(value="Reserva plazas en el vuelo indicado")
	@PutMapping(value="actualizarPlazas/{idVuelo}/{plazas}")
	public void actualizarPlazas(@ApiParam(value="Id del vuelo a actualizar")@PathVariable("idVuelo") int idVuelo,
			@ApiParam(value="Plazas del vuelo a reservar")@PathVariable("plazas") int plazas) {
		service.actualizarPlazas(idVuelo, plazas);
	}

}

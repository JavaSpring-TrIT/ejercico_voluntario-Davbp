package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.service.HotelesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@CrossOrigin("*")
@RestController
public class HotelesController {

	@Value("${eureka.instance.instance-id}")
	String instancia;
	@Autowired
	HotelesService service;
	
	@ApiOperation(value="Busca todos los hoteles")
	@GetMapping(value="hotelesDisponibles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelesDisponibles() {
		System.out.println("Instancia: " + instancia);
		return service.hoteles();
	}
	
	@ApiOperation(value="Busca un hotel por el nombre")
	@GetMapping(value="hotel/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotel(@ApiParam(value="Nombre del hotel a buscar")@PathVariable("nombre") String nombre) {
		return service.buscarHotel(nombre);
	}

}

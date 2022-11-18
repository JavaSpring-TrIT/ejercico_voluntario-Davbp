package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reservas.dao.ReservasDao;
import com.reservas.model.Hotel;
import com.reservas.model.Reserva;

@Service
public class ReservasServiceImpl implements ReservasService {
	
	@Autowired
	RestTemplate template;
	@Autowired
	ReservasDao dao;
	
	private String urlHoteles = "http://172.27.64.1:9000/shoteles/";
	private String urlVuelos = "http://172.27.64.1:9000/svuelos/";
	
	@Override
	public void altaReserva(Reserva reserva) {
		template.put(urlVuelos+"actualizarPlazas/{idVuelo}/{plazas}", reserva, reserva.getIdVuelo(), reserva.getPersonas());
		dao.save(reserva);
	}

	@Override
	public List<Reserva> obtenerReservas(String hotel) {
		Hotel h = template.getForObject(urlHoteles+"hotel/"+hotel, Hotel.class);
		return dao.findByIdHotel(h.getIdHotel());
	}
	

}

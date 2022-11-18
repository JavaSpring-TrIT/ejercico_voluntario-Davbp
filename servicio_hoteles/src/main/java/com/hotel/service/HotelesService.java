package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;


public interface HotelesService {
	List<Hotel> hoteles();	
	Hotel buscarHotel(String hotel);	

}

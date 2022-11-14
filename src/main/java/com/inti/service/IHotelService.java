package com.inti.service;

import java.util.List;

import com.inti.model.Hotel;

public interface IHotelService {

	public List<Hotel> getHotels();

	public Hotel getHotel(int id);

	public void saveHotel(Hotel hot);

	public void deleteHotel(int id);

}

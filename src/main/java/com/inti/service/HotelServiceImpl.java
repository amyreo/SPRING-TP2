package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	IHotelRepository ihr;

	@Override
	public List<Hotel> getHotels() {
		List<Hotel> lHotel = ihr.findAll();
		return lHotel;
	}

	@Override
	public Hotel getHotel(int id) {
		return ihr.findById(id).get();
	}

	@Override
	public void saveHotel(Hotel hot) {
		ihr.save(hot);

	}

	@Override
	public void deleteHotel(int id) {
		ihr.delete(ihr.findById(id).get());

	}

}

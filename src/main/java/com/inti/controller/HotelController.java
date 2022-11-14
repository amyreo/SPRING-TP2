package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Hotel;
import com.inti.model.Salarie;
import com.inti.repository.IHotelRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Hotel")
@Slf4j
public class HotelController {

	@Autowired
	IHotelRepository ihr;

	@GetMapping("/listeHotel")
	public List<Hotel> getHotels() {
		return ihr.findAll();
	}

	@PostMapping("/saveHotel")
	public boolean saveHotel(@RequestBody Hotel h) {
		if (h.getNumero() > 0) {
			log.info("Le Hotel a été enregisté");
			ihr.save(h);
			return true;
		}
		return false;
	}

	@GetMapping("/getHotel/{numero}")
	public Hotel getHotel(@PathVariable int numero) {
		try {
			ihr.findById(numero).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/deleteHotel/{numero}")
	public boolean deleteHotel(@PathVariable int numero) {
		if (numero != 0) {
			ihr.deleteById(numero);
			return true;
		}
		return false;
	}

	@PostMapping("ajoutSalarie/{idH}")
	public boolean associerSalarieToHotel(@PathVariable int idH, @RequestBody Salarie sal) {

		try {
			Hotel hotel = ihr.findById(idH).get();
			List<Salarie> listeSalarie = hotel.getLSalarie();
			listeSalarie.add(sal);
			log.debug("On a ajouté le salarié à la liste");

			hotel.setLSalarie(listeSalarie);
			ihr.save(hotel);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}

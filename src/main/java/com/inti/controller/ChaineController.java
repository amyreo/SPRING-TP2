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

import com.inti.model.Chaine;
import com.inti.model.Hotel;
import com.inti.repository.IChaineRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Chaine")
@Slf4j
public class ChaineController {

	@Autowired
	IChaineRepository icr;

	@GetMapping("/listeChaine")
	public List<Chaine> getChaines() {
		return icr.findAll();
	}

	@PostMapping("/saveChaine")
	public boolean saveChaine(@RequestBody Chaine c) {
		if (c.getIdC() > 0) {
			log.info("Le Chaine a été enregisté");
			icr.save(c);
			return true;
		}
		return false;
	}

	@GetMapping("/getChaine/{numero}")
	public Chaine getChaine(@PathVariable int numero) {
		try {
			icr.findById(numero).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/deleteChaine/{numero}")
	public boolean deleteChaine(@PathVariable int numero) {
		if (numero != 0) {
			icr.deleteById(numero);
			return true;
		}
		return false;
	}

	@PostMapping("ajoutHotel/{idC}")
	public boolean associerHotelToChaine(@PathVariable int idC, @RequestBody Hotel hot) {

		try {
			Chaine chaine = icr.findById(idC).get();
			List<Hotel> listeHotel = chaine.getLHotel();
			listeHotel.add(hot);
			log.debug("On a ajouté l'hotel à la liste");

			chaine.setLHotel(listeHotel);
			icr.save(chaine);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}

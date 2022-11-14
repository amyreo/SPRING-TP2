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
import com.inti.repository.IChaineRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Chaine")
@Slf4j
public class ChaineController {
	
	@Autowired
	IChaineRepository ihr;
	
	@GetMapping("/listeChaine")
	public List<Chaine> getChaines() {
		return ihr.findAll();
	}

	@PostMapping("/saveChaine")
	public boolean saveChaine(@RequestBody Chaine c) {
		if (c.getIdC() > 0) {
			log.info("Le Chaine a été enregisté");
			ihr.save(c);
			return true;
		}
		return false;
	}
	
	@GetMapping("/getChaine/{numero}")
	public Chaine getChaine(@PathVariable int numero) {
		try {
			ihr.findById(numero).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/deleteChaine/{numero}")
	public boolean deleteChaine(@PathVariable int numero) {
		if (numero != 0) {
			ihr.deleteById(numero);
			return true;
		}
		return false;
	}

}

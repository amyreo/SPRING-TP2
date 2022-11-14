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

import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Salarie")
@Slf4j
public class SalarieController {
	
	@Autowired
	ISalarieRepository isr;
	
	@GetMapping("/listeSalarie")
	public List<Salarie> getSalaries() {
		return isr.findAll();
	}

	@PostMapping("/saveSalarie")
	public boolean saveSalarie(@RequestBody Salarie s) {
		if (s.getReference() > 0) {
			log.info("Le Salarie a été enregisté");
			isr.save(s);
			return true;
		}
		return false;
	}
	
	@GetMapping("/getSalarie/{numero}")
	public Salarie getSalarie(@PathVariable int numero) {
		try {
			isr.findById(numero).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/deleteSalarie/{numero}")
	public boolean deleteSalarie(@PathVariable int numero) {
		if (numero != 0) {
			isr.deleteById(numero);
			return true;
		}
		return false;
	}

}

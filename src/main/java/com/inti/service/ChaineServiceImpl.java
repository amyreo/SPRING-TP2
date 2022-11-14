package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Chaine;
import com.inti.repository.IChaineRepository;

@Service
public class ChaineServiceImpl implements IChaineService {

	@Autowired
	IChaineRepository ihr;

	@Override
	public List<Chaine> getChaines() {
		List<Chaine> lChaine = ihr.findAll();
		return lChaine;
	}

	@Override
	public Chaine getChaine(int id) {
		return ihr.findById(id).get();
	}

	@Override
	public void saveChaine(Chaine cha) {
		ihr.save(cha);

	}

	@Override
	public void deleteChaine(int id) {
		ihr.delete(ihr.findById(id).get());

	}

}

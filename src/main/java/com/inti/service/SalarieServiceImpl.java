package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@Service
public class SalarieServiceImpl implements ISalarieService {

	@Autowired
	ISalarieRepository isr;

	@Override
	public List<Salarie> getSalaries() {
		List<Salarie> lSalarie = isr.findAll();
		return lSalarie;
	}

	@Override
	public Salarie getSalarie(int id) {
		return isr.findById(id).get();
	}

	@Override
	public void saveSalarie(Salarie sal) {
		isr.save(sal);

	}

	@Override
	public void deleteSalarie(int id) {
		isr.delete(isr.findById(id).get());

	}

}

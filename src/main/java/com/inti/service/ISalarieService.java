package com.inti.service;

import java.util.List;

import com.inti.model.Salarie;

public interface ISalarieService {

	public List<Salarie> getSalaries();

	public Salarie getSalarie(int id);

	public void saveSalarie(Salarie sal);

	public void deleteSalarie(int id);

}

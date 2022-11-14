package com.inti.service;

import java.util.List;

import com.inti.model.Chaine;

public interface IChaineService {

	public List<Chaine> getChaines();

	public Chaine getChaine(int id);

	public void saveChaine(Chaine cha);

	public void deleteChaine(int id);

}

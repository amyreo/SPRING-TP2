package com.inti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Chaine;

@Repository
@Transactional
public interface IChaineRepository extends JpaRepository<Chaine, Integer> {

}

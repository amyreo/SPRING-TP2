package com.inti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Salarie;

@Repository
@Transactional
public interface ISalarieRepository extends JpaRepository<Salarie, Integer> {

}

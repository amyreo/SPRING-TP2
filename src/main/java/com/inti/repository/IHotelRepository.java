package com.inti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Hotel;

@Repository
@Transactional
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

}

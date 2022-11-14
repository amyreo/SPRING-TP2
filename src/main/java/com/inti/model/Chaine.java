package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chaine {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int idC;
	protected String nomC;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chaine")
	private List<Hotel> lHotel;
}

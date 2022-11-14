package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int numero;
	protected String numTel;
	protected String adresse;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
	private List<Salarie> lSalarie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idChaine")
	protected Chaine chaine;

}

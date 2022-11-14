package com.inti.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salarie {
	@Id
	protected int reference;
	protected String type;
	protected String dateN;
	protected String dateE;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idHotel")
	protected Hotel hotel;

}

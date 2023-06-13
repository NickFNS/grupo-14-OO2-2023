package com.grupo14.oob2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "medicion_estacionamiento")
public class MedicionEstacionamiento extends Medicion {

	@Column(name = "place_number")
	private int place_number;

	@Column(name = "occupied")
	private boolean occupied;

}

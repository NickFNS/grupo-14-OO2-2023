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
@Table(name = "estacionamiento")
public class Estacionamiento extends Dispositivo {

	@Column(name = "place_number")
	private int placeNumber;

}

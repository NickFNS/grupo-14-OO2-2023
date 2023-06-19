package com.grupo14.oob2.entities;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Banio extends Dispositivo {

	@Column(name = "bathroom_number")
	private int bathroom_number;

	public int getBathroom_number() {
		return bathroom_number;
	}

	public void setBathroom_number(int bathroom_number) {
		this.bathroom_number = bathroom_number;
	}

}
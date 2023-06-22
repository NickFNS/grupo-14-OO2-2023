package com.grupo14.oob2.entities;

import java.time.LocalDateTime;

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
@Table(name = "medicion_banio")
public class MedicionBanio extends Medicion {

	@Column(name = "cleaning_day")
	public LocalDateTime cleaning_day;

	@Column(name = "occupied")
	public boolean occupied;

	public LocalDateTime getCleaning_day() {
		return cleaning_day;
	}

	public void setCleaning_day(LocalDateTime cleaning_day) {
		this.cleaning_day = cleaning_day;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

}
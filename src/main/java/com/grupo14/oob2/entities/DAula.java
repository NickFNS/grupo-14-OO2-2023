package com.grupo14.oob2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "d_aula")
public class DAula extends Dispositivo {

	@Column(name = "open_door")
	protected boolean openDoor;

	@Column(name = "lights_on")
	protected boolean lightsOn;

	@Column(name = "computers_on")
	protected boolean computersOn;

	@Column(name = "open_windows")
	protected boolean openWindows;

	@Column(name = "in_use")
	protected boolean inUse;

	public DAula() {
	}

	public DAula(boolean openDoor, boolean lightsOn, boolean computersOn, boolean openWindows, boolean inUse) {
		super();
		this.openDoor = openDoor;
		this.lightsOn = lightsOn;
		this.computersOn = computersOn;
		this.openWindows = openWindows;
		this.inUse = inUse;
	}

	public boolean isOpenDoor() {
		return openDoor;
	}

	public void setOpenDoor(boolean openDoor) {
		this.openDoor = openDoor;
	}

	public boolean isLightsOn() {
		return lightsOn;
	}

	public void setLightsOn(boolean lightsOn) {
		this.lightsOn = lightsOn;
	}

	public boolean isComputersOn() {
		return computersOn;
	}

	public void setComputersOn(boolean computersOn) {
		this.computersOn = computersOn;
	}

	public boolean isOpenWindows() {
		return openWindows;
	}

	public void setOpenWindows(boolean openWindows) {
		this.openWindows = openWindows;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

}

package com.grupo14.oob2.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSector;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sector")
	private Set<Dispositivo> dispositivos = new HashSet<Dispositivo>();

	@Column(name = "creadoEn")
	@CreationTimestamp
	private LocalDateTime creadoEn;

	@Column(name = "actualizadoEn")
	@UpdateTimestamp
	private LocalDateTime actualizadoEn;

	public Sector() {
	}

	public Sector(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Sector(String nombre, Set<Dispositivo> dispositivos) {
		super();
		this.nombre = nombre;
		this.dispositivos = dispositivos;
	}

	public int getIdSector() {
		return idSector;
	}

	protected void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Set<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public LocalDateTime getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(LocalDateTime actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}

}

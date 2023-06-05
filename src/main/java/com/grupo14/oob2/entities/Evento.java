package com.grupo14.oob2.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "activo")
	private boolean activo;

//  Un evento puede tener mas de un dispositivo? 
//	@OneToMany o @OneToOne?
//  @JoinColumn(name = "dispositivo_id", nullable = false)	
	private Dispositivo dispositivo;

	@Column(name = "fechaHora")
	private LocalDateTime fechaHora;

//  No se si los eventos deberian tener esto o no? Creo que no
//	@Column(name = "creadoEn")
//	@CreationTimestamp
//	private LocalDateTime creadoEn;
//
//	@Column(name = "actualizadoEn")
//	@UpdateTimestamp
//	private LocalDateTime actualizadoEn;

	public Evento() {
	}

	public Evento(int idEvento, String descripcion, boolean activo, Dispositivo dispositivo, LocalDateTime fechaHora) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.activo = activo;
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}

	public int getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

}

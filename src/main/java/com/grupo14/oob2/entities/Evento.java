package com.grupo14.oob2.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;

	@Column(name = "descripcion", nullable = false, length = 45)
	private String descripcion;

	@Column(name = "enabled")
	private boolean enabled;

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

	public Evento(int idEvento, String descripcion, boolean enabled, Dispositivo dispositivo, LocalDateTime fechaHora) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.enabled = enabled;
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}

}

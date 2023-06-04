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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "dispositivo")
// Abstract para que hereden cada dispositivo
public abstract class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDispositivo;

	@Column(name = "nombre", unique = true, nullable = false, length = 45)
	private String nombre;

	@Column(name = "enabled")
	private boolean enabled;

//	No seria lo mismo que enabled?	
//	@Column(name = "activo")
//	private boolean activo;

	@Column(name = "tipo", nullable = false, length = 45)
	private String tipo;

	@Column(name = "creadoEn")
	@CreationTimestamp
	private LocalDateTime creadoEn;

	@Column(name = "actualizadoEn")
	@UpdateTimestamp
	private LocalDateTime actualizadoEn;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dispositivo")
//	private Set<Evento> eventos = new HashSet<Evento>();

	public Dispositivo() {
	}

	public Dispositivo(String nombre, boolean enabled, String tipo) {
		super();
		this.nombre = nombre;
		this.enabled = enabled;
		this.tipo = tipo;
	}

//	public Dispositivo(String nombre, boolean enabled, String tipo, Set<Evento> eventos) {
//		super();
//		this.nombre = nombre;
//		this.enabled = enabled;
//		this.tipo = tipo;
//		this.eventos = eventos;
//	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	protected void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

//	public Set<Evento> getEventos() {
//		return eventos;
//	}
//
//	public void setEventos(Set<Evento> eventos) {
//		this.eventos = eventos;
//	}

}

package com.grupo14.oob2.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "medicion")
public abstract class Medicion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idMedicion;

	@CreationTimestamp
	@Column(name = "registryDateTime")
	protected LocalDateTime registryDateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dispositivo")
	protected Dispositivo dispositivo;

	// TODO: Verificar que no funciona Lombok.
	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

}

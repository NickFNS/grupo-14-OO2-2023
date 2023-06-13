package com.grupo14.oob2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "estacionamiento")
public class Estacionamiento extends Dispositivo {

	// TODO: Verificar por que no me crea el set si no estan los tags.
	// No creo necesario tener que crear un Model, porque solo hay un atributo para
	// mostrar de Estacionamiento
	@ElementCollection
	@CollectionTable(name = "estacionamiento", joinColumns = @JoinColumn(name = "id_dispositivo"))
	@Column(name = "places")
	private Set<Integer> places = new HashSet<Integer>();

	// TODO: Revisar que no funciona el Lombok
	public Set<Integer> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Integer> places) {
		this.places = places;
	}

}
package com.grupo14.oob2.services;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;

public interface DispositivoService {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract List<Dispositivo> getAll();

	public Dispositivo insertOrUpdateDispositivo(Dispositivo d);

	public abstract boolean removeByIdDispositivo(int idDispositivo);

	// ESTACIONAMIENTO:
	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> FindAllEstacionamiento();

	// Changed LocalDate to Date.
	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByDate(Date date);

	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByName(String name);

	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByDateAndName(Date date, String name);
	
	@ModelAttribute("estacionamiento")
	public abstract Estacionamiento findEstacionamientoByIdDispositivo(int idDispositivo);

}

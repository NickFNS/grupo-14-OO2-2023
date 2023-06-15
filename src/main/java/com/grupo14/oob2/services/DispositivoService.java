package com.grupo14.oob2.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;

public interface DispositivoService {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract List<Dispositivo> getAll();

	@ModelAttribute("estacionamiento")
	public abstract List<Dispositivo> FindAllEstacionamiento();

	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByDate(LocalDate date);

	public Dispositivo insertOrUpdateDispositivo(Dispositivo d);

	public abstract boolean removeByIdDispositivo(int idDispositivo);

}

package com.grupo14.oob2.services;

import java.util.List;

import com.grupo14.oob2.entities.*;

public interface MedicionService {

	public Medicion findByIdMedicion(int idMedicion);

	public List<Medicion> findMedicionByDispositivo(int idDispositivo);

	public List<Medicion> getAll();

	public Medicion insertOrUpdate(Medicion m);

	public abstract boolean removeByIdMedicion(int idMedicion);

	// ESTACIONAMIENTOS
	public List<MedicionEstacionamiento> getAllMedicionEstacionamiento();

	public List<MedicionEstacionamiento> getUltimaMedicionEstacionamiento(Estacionamiento estacionamiento);

	// ESTACIONAMIENTOS
	public List<MedicionDAula> getAllMedicionDAula();

	public List<MedicionDAula> getUltimaMedicionDAulao(DAula daula);

	// BAÑOS

	public List<MedicionBanio> getAllMedicionBanio();
	public List<MedicionBanio> getUltimaMedicionBanio(Banio banio);

}

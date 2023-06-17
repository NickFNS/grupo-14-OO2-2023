package com.grupo14.oob2.services;

import java.util.List;

import com.grupo14.oob2.entities.Medicion;
import com.grupo14.oob2.entities.MedicionEstacionamiento;

public interface MedicionService {

	public Medicion findByIdMedicion(int idMedicion);

	public List<Medicion> findMedicionByDispositivo(int idDispositivo);

	public List<Medicion> getAll();

	public Medicion insertOrUpdate(Medicion m);

	public abstract boolean removeByIdMedicion(int idMedicion);
	
	// ESTACIONAMIENTOS
	public List<MedicionEstacionamiento> getAllMedicionEstacionamiento();

}

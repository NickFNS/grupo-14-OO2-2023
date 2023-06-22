package com.grupo14.oob2.services.implementation;

import java.util.List;

import com.grupo14.oob2.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.repositories.MedicionRepository;
import com.grupo14.oob2.services.MedicionService;

@Service
public class MedicionServiceImpl implements MedicionService {

	@Autowired
	private MedicionRepository medicionRepository;

	@Override
	public Medicion findByIdMedicion(int idMedicion) {
		return medicionRepository.findByIdMedicion(idMedicion);
	}

	@Override
	public List<Medicion> findMedicionByDispositivo(int idDispositivo) {
		return medicionRepository.findMedicionByDispositivo(idDispositivo);
	}

	@Override
	public List<Medicion> getAll() {
		return medicionRepository.findAll();
	}

	@Override
	public Medicion insertOrUpdate(Medicion m) {
		Medicion newMedicion = medicionRepository.save(m);
		// return modelMapper.map(newMedicion, MedicionModel.class);
		return newMedicion;
	}

	@Override
	public boolean removeByIdMedicion(int idMedicion) {
		try {
			// Cambiar esto a que en vez de eliminarlo, lo "inactive", la baja tiene que ser
			// Logica.
			medicionRepository.deleteById(idMedicion);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// ESTACIONAMIENTO
	@Override
	public List<MedicionEstacionamiento> getAllMedicionEstacionamiento() {
		return medicionRepository.getAllMedicionEstacionamiento();
	}

	@Override
	public List<MedicionEstacionamiento> getUltimaMedicionEstacionamiento(Estacionamiento estacionamiento) {
		return medicionRepository.findUltimaMedicionEstacionamiento(estacionamiento);
	}

	// Aula
	@Override
	public List<MedicionDAula> getAllMedicionDAula() {
		return medicionRepository.getAllMedicionDAula();
	}

	@Override
	public List<MedicionDAula> getUltimaMedicionDAulao(DAula daula) {
		return medicionRepository.findUltimaMedicionDAula(daula);
	}
	
	// BAÑO
	
	@Override
	public List<MedicionBanio> getAllMedicionBanio() {
		return medicionRepository.getAllMedicionBanio();
	}

	@Override
	public List<MedicionBanio> getUltimaMedicionBanio(Banio banio) {
		return medicionRepository.findUltimaMedicionBanio(banio);
	}

}

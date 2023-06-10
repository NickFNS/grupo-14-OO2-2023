package com.grupo14.oob2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Medicion;
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
	public Medicion insertOrUpdateMedicion(Medicion m) {
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

}

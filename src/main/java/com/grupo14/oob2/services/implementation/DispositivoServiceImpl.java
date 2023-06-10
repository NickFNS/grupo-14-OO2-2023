package com.grupo14.oob2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.repositories.DispositivoRepository;
import com.grupo14.oob2.services.DispositivoService;

@Service
public class DispositivoServiceImpl implements DispositivoService {

	@Autowired
	private DispositivoRepository dispositivoRepository;

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.getById(idDispositivo);
	}

	// A revisar
	@Override
	public List<Dispositivo> findByTipoDesc(String tipo) {
		return null;
	}

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	// public DispositivoModel
	public Dispositivo insertOrUpdateDispositivo(Dispositivo d) {
		Dispositivo newDispositivo = dispositivoRepository.save(d);
		// return modelMapper.map(newDispositivo, DispositivoModel.class);
		return newDispositivo;
	}

	@Override
	public boolean removeByIdDispositivo(int idDispositivo) {
		try {
			// Cambiar esto a que en vez de eliminarlo, lo "inactive", la baja tiene que ser
			// Logica.
			dispositivoRepository.deleteById(idDispositivo);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}

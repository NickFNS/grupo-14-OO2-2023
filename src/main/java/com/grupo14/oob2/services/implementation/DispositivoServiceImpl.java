package com.grupo14.oob2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.repositories.DispositivoRepository;
import com.grupo14.oob2.services.DispositivoService;


@Service
public class DispositivoServiceImpl implements DispositivoService {

	@Autowired
	private DispositivoRepository dispositivoRepository;


	@Override
	public Dispositivo findByNombre(String nombre) {
		return null;
	}

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return null;
	}

	@Override
	public List<Dispositivo> findByTipoDesc(String tipo) {
		return null;
	}

	@Override
	public List<Dispositivo> getAll() {
		return null;
	}


	@Override
	public boolean removeByIdDispositivo(int idDispositivo) {
		try {
			dispositivoRepository.deleteById(idDispositivo);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}

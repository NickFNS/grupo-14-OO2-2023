package com.grupo14.oob2.services.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Banio;
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

	@Override
	public List<Dispositivo> findByTipoDesc(String tipo) {
		return null;
	}

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}
	
	// A desarrollar
	@Override
	public Dispositivo insertOrUpdateDispositivo(Dispositivo d) {
		return d;
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

	// BanioS:

	@Override
	public List<Banio> findAllBanios() {
		return dispositivoRepository.findAllBanios();
	}

	@Override
	public List<Banio> findBaniosByDate(Date date) {
		return dispositivoRepository.findBaniosByDate(date);
	}

	@Override
	public List<Banio> findBaniosByName(String name) {
		return dispositivoRepository.findBaniosByName(name);
	}

	@Override
	public List<Banio> findBaniosByDateAndName(Date date, String name) {
		return dispositivoRepository.findBaniosByDateAndName(date, name);
	}

	@Override
	public Banio findBanioByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.findBanioByIdDispositivo(idDispositivo);
	}

}
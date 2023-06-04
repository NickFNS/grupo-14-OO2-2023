package com.grupo14.oob2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.repositories.IDispositivoRepository;
import com.grupo14.oob2.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository repo;

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return repo.findByIdDispositivo(idDispositivo);
	}

	@Override
	public Dispositivo findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	@Override
	public List<Dispositivo> findByTipoDesc(String tipo) {
		return repo.findByTipoDesc(tipo);
	}

	@Override
	public List<Dispositivo> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean removeByIdDispositivo(int idDispositivo) {
		try {
			repo.deleteById(idDispositivo);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}

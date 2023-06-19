package com.grupo14.oob2.services.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;
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


	// TODO: Verificar que funcione bien el agregar.
	public Dispositivo insertOrUpdateEstacionamiento(Dispositivo d) {
		if (d instanceof Estacionamiento) {
			Estacionamiento estacionamiento = (Estacionamiento) d;
			if (estacionamiento.getIdDispositivo() != 0) {
				// El estacionamiento tiene un ID distinto de cero, lo que indica que ya existe
				// en la base de datos
				Optional<Dispositivo> existingDispositivo = dispositivoRepository
						.findById(estacionamiento.getIdDispositivo());
				if (existingDispositivo.isPresent() && existingDispositivo.get() instanceof Estacionamiento) {
					// Actualizar el estacionamiento existente con los valores del estacionamiento
					// pasado como parámetro
					Estacionamiento existingEstacionamiento = (Estacionamiento) existingDispositivo.get();
					existingEstacionamiento.setPlaces(estacionamiento.getPlaces());
					// Actualiza otros campos si es necesario
					// ...
					// Guardar el estacionamiento actualizado en la base de datos
					Dispositivo savedDispositivo = dispositivoRepository.save(existingEstacionamiento);
					return savedDispositivo;
				}
			}
		}
		// El estacionamiento no existe en la base de datos, crear uno nuevo
		Dispositivo newDispositivo = dispositivoRepository.save(d);
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

	
	//ESTACIONAMIENTOS: 
	
	@Override
	public List<Estacionamiento> FindAllEstacionamiento() {
		return dispositivoRepository.findAllEstacionamientos();
	}
	// Changed LocalDate to Date.
	@Override
	public List<Estacionamiento> findEstacionamientosByDate(Date date) {
		return dispositivoRepository.findEstacionamientosByDate(date);
	}

	@Override
	public List<Estacionamiento> findEstacionamientosByName(String name) {
		return dispositivoRepository.findEstacionamientosByName(name);
	}

	@Override
	public List<Estacionamiento> findEstacionamientosByDateAndName(Date date, String name) {
		return dispositivoRepository.findEstacionamientosByDateAndName(date, name);
	}

	@Override
	public Estacionamiento findEstacionamientoByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.findEstacionamientoByIdDispositivo(idDispositivo);
	}

}

package com.grupo14.oob2.services.implementation;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 830a654827cdc339691adffeaa9f7f9f67266848
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Banio;
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

	@Override
	public List<Dispositivo> findByTipoDesc(String tipo) {
		return null;
	}

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

<<<<<<< HEAD
	// TODO: Verificar que funcione bien el agregar.
	public Dispositivo insertOrUpdateEstacionamiento(Dispositivo d) {
		if (d instanceof Estacionamiento) {
			Estacionamiento estacionamiento = (Estacionamiento) d;
//			if (estacionamiento.getIdDispositivo() != 0) {
//				// El estacionamiento tiene un ID distinto de cero, lo que indica que ya existe
//				// en la base de datos
//				Optional<Dispositivo> existingDispositivo = dispositivoRepository
//						.findById(estacionamiento.getIdDispositivo());
//				if (existingDispositivo.isPresent() && existingDispositivo.get() instanceof Estacionamiento) {
//					// Actualizar el estacionamiento existente con los valores del estacionamiento
//					// pasado como parámetro
//					Estacionamiento existingEstacionamiento = (Estacionamiento) existingDispositivo.get();
//					existingEstacionamiento.setPlaces(estacionamiento.getPlaces());
//					// Actualiza otros campos si es necesario
//					// ...
//					// Guardar el estacionamiento actualizado en la base de datos
//					Dispositivo savedDispositivo = dispositivoRepository.save(existingEstacionamiento);
//					return savedDispositivo;
//				}
//			}
			List<Estacionamiento> estacionamientos = dispositivoRepository.findAllEstacionamientos();
			if (estacionamientos.contains(estacionamiento)) {
				estacionamiento.setUpdated_at(LocalDateTime.now());
			}
		}
		// El estacionamiento no existe en la base de datos, crear uno nuevo
=======
	// A desarrollar
	@Override
	public Dispositivo insertOrUpdateBanio(Dispositivo d) {
		if (d instanceof Banio) {
			Banio Banio = (Banio) d;
			if (Banio.getIdDispositivo() != 0) {
				Optional<Dispositivo> existingDispositivo = dispositivoRepository
						.findById(Banio.getIdDispositivo());
				if (existingDispositivo.isPresent() && existingDispositivo.get() instanceof Banio) {
					Banio existingBanio = (Banio) existingDispositivo.get();
					existingBanio.setBathroom_number(Banio.getBathroom_number());
					Dispositivo savedDispositivo = dispositivoRepository.save(existingBanio);
					return savedDispositivo;
				}
			}
		}
>>>>>>> 830a654827cdc339691adffeaa9f7f9f67266848
		Dispositivo newDispositivo = dispositivoRepository.save(d);
		return newDispositivo;
	}

	@Override
<<<<<<< HEAD
	public void removeByIdDispositivo(int idDispositivo) {
		Dispositivo d = dispositivoRepository.findById(idDispositivo);
		d.setEnabled(false);
		dispositivoRepository.save(d);
	}

	// ESTACIONAMIENTOS:

	@Override
	public List<Estacionamiento> FindAllEstacionamiento() {
		return dispositivoRepository.findAllEstacionamientos();
	}

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
=======
	public boolean removeByIdDispositivo(int idDispositivo) {
		try {
			dispositivoRepository.deleteById(idDispositivo);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
>>>>>>> 830a654827cdc339691adffeaa9f7f9f67266848
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
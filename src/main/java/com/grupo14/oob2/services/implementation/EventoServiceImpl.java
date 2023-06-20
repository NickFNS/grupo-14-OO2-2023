package com.grupo14.oob2.services.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Evento;
import com.grupo14.oob2.repositories.EventoRepository;
import com.grupo14.oob2.services.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public Evento findByIdEvento(int idEvento) {
		return eventoRepository.findByIdEvento(idEvento);
	}

	@Override
	public Evento findByDescription(String description) {
		return eventoRepository.findByDescription(description);
	}

	@Override
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}

	@Override
	public Evento insertOrUpdateEvento(Evento e) {
		Evento newEvento = eventoRepository.save(e);
		// return modelMapper.map(newDispositivo, DispositivoModel.class);
		return newEvento;
	}

	@Override
	public boolean removeByIdEvento(int idEvento) {
		try {
			// Cambiar esto a que en vez de eliminarlo, lo "inactive", la baja tiene que ser
			// Logica.
			eventoRepository.deleteById(idEvento);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Evento> findByDispositivoType(String type) {
		return eventoRepository.findByDispositivoType(type);
	}
	
	// Buscar por tipo de dispositivo, de manera descendente por id de evento.
	@Override
	public List<Evento> findByDispositivoTypeOrderByIdEventoDesc(String type) {
		return eventoRepository.findByDispositivoTypeOrderByIdEventoDesc(type);
	}

	// Filtros avanados para busqueda de eventos:
	@Override
	public List<Evento> findByTypeAndDispositivoIdOrderByIdEventoDesc(String type, int idDispositivo) {
		return eventoRepository.findByTypeAndDispositivoIdOrderByIdEventoDesc(type, idDispositivo);
	}

	@Override
	public List<Evento> findByTypeAndDescriptionContainingOrderByIdEventoDesc(String type, String description) {
		return eventoRepository.findByTypeAndDescriptionContainingOrderByIdEventoDesc(type, description);
	}

	@Override
	public List<Evento> findByTypeAndDateAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(String type,
			Date date, int idDispositivo, String description) {
		return eventoRepository.findByTypeAndDateAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(type, date, idDispositivo, description);
	}

	@Override
	public List<Evento> findByTypeAndDateAndDispositivoIdOrderByIdEventoDesc(String type, Date date,
			int idDispositivo) {
		return eventoRepository.findByTypeAndDateAndDispositivoIdOrderByIdEventoDesc(type, date, idDispositivo);
	}

	@Override
	public List<Evento> findByTypeAndDateAndDescriptionContainingOrderByIdEventoDesc(String type, Date date,
			String description) {
		return eventoRepository.findByTypeAndDateAndDescriptionContainingOrderByIdEventoDesc(type, date, description);
	}

	@Override
	public List<Evento> findByTypeAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(String type, int idDispositivo, String description) {
		return eventoRepository.findByTypeAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(type,idDispositivo, description);
	}

	@Override
	public List<Evento> findByTypeAndDateOrderByIdEventoDesc(String type, Date date) {
		return eventoRepository.findByTypeAndDateOrderByIdEventoDesc(type, date);
	}


	
}

package com.grupo14.oob2.services.implementation;

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

}

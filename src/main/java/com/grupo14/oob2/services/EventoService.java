package com.grupo14.oob2.services;

import java.util.Date;
import java.util.List;

import com.grupo14.oob2.entities.Evento;

public interface EventoService {

	public Evento findByIdEvento(int idEvento);

	public abstract Evento findByDescription(String description);

	public List<Evento> getAll();

	public Evento insertOrUpdateEvento(Evento e);

	public abstract boolean removeByIdEvento(int idEvento);

	// Buscar segun tipo de dispositivo:
	public List<Evento> findByDispositivoType(String type);

	public List<Evento> findByDispositivoTypeOrderByIdEventoDesc(String type);

	// Filtros avanzados:
	public List<Evento> findByTypeAndDateAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(String type,
			Date date, int idDispositivo, String description);

	List<Evento> findByTypeAndDateAndDispositivoIdOrderByIdEventoDesc(String type, Date date, int idDispositivo);

	List<Evento> findByTypeAndDateAndDescriptionContainingOrderByIdEventoDesc(String type, Date date,
			String description);

	List<Evento> findByTypeAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(String type, int idDispositivo,
			String description);

	List<Evento> findByTypeAndDateOrderByIdEventoDesc(String type, Date date);

	List<Evento> findByTypeAndDispositivoIdOrderByIdEventoDesc(String type, int idDispositivo);

	List<Evento> findByTypeAndDescriptionContainingOrderByIdEventoDesc(String type, String description);

}

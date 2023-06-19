package com.grupo14.oob2.services;

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
	
}

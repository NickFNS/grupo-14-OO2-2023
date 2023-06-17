package com.grupo14.oob2.services;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.entities.Dispositivo;

public interface DispositivoService {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract List<Dispositivo> getAll();

	public Dispositivo insertOrUpdateDispositivo(Dispositivo d);

	public abstract boolean removeByIdDispositivo(int idDispositivo);
	
	// BAÑO:
	
	@ModelAttribute("banio")
	public abstract List<Banio> findAllBanios();

	// Changed LocalDate to Date.
	@ModelAttribute("banio")
	public abstract List<Banio> findBaniosByDate(Date date);

	@ModelAttribute("banio")
	public abstract List<Banio> findBaniosByName(String name);

	@ModelAttribute("banio")
	public abstract List<Banio> findBaniosByDateAndName(Date date, String name);

}

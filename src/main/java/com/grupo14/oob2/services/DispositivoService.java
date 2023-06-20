package com.grupo14.oob2.services;

import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;

=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupo14.oob2.entities.Banio;
>>>>>>> 830a654827cdc339691adffeaa9f7f9f67266848
import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;

public interface DispositivoService {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract List<Dispositivo> getAll();

<<<<<<< HEAD
	public Dispositivo insertOrUpdateEstacionamiento(Dispositivo d);
=======
	public Dispositivo insertOrUpdateBanio(Dispositivo d);
>>>>>>> 830a654827cdc339691adffeaa9f7f9f67266848

	public abstract void removeByIdDispositivo(int idDispositivo);

	// ESTACIONAMIENTO:
	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> FindAllEstacionamiento();

	// Changed LocalDate to Date.
	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByDate(Date date);

	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByName(String name);

	@ModelAttribute("estacionamiento")
	public abstract List<Estacionamiento> findEstacionamientosByDateAndName(Date date, String name);
	
	@ModelAttribute("estacionamiento")
	public abstract Estacionamiento findEstacionamientoByIdDispositivo(int idDispositivo);

	// BAÑO:

	@Query("SELECT b FROM Banio b WHERE b.idDispositivo =(:idDispositivo)")
	Banio findBanioByIdDispositivo(int idDispositivo);

	@Query("SELECT b FROM Banio b")
	List<Banio> findAllBanios();

	@Query("SELECT b FROM Banio b WHERE FUNCTION('DATE', b.created_at) = :date")
	List<Banio> findBaniosByDate(@Param("date") Date date);

	@Query("SELECT b FROM Banio b WHERE b.name = (:name)")
	List<Banio> findBaniosByName(@Param("name") String name);

	@Query("SELECT b FROM Banio b WHERE FUNCTION('DATE', b.created_at) = :date AND b.name = (:name)")
	List<Banio> findBaniosByDateAndName(@Param("date") Date date, @Param("name") String name);

}

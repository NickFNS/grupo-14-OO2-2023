package com.grupo14.oob2.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.entities.Dispositivo;

public interface DispositivoService {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract List<Dispositivo> getAll();

	public Dispositivo insertOrUpdateBanio(Dispositivo d);

	public abstract boolean removeByIdDispositivo(int idDispositivo);

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

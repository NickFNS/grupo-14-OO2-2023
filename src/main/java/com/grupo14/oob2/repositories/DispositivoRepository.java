package com.grupo14.oob2.repositories;

import com.grupo14.oob2.entities.DAula;
import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {

	Dispositivo findById(int idDispositivo);

	// Estacionamiento
	@Query("SELECT e FROM Estacionamiento e WHERE e.idDispositivo =(:idDispositivo)")
	Estacionamiento findEstacionamientoByIdDispositivo(int idDispositivo);

	@Query("SELECT e FROM Estacionamiento e")
	List<Estacionamiento> findAllEstacionamientos();

	@Query("SELECT e FROM Estacionamiento e WHERE FUNCTION('DATE', e.created_at) = :date")
	List<Estacionamiento> findEstacionamientosByDate(@Param("date") Date date);

	@Query("SELECT e FROM Estacionamiento e WHERE e.enabled = (:enabled)")
	List<Estacionamiento> findEstacionamientosByEnabled(@Param("enabled") boolean enabled);

	@Query("SELECT e FROM Estacionamiento e WHERE e.name = (:name)")
	List<Estacionamiento> findEstacionamientosByName(@Param("name") String name);

	@Query("SELECT e FROM Estacionamiento e WHERE FUNCTION('DATE', e.created_at) = :date AND e.name = (:name)")
	List<Estacionamiento> findEstacionamientosByDateAndName(@Param("date") Date date, @Param("name") String name);

	// Baños
	@Query("SELECT b FROM Banio b WHERE b.idDispositivo =(:idDispositivo)")
	Banio findBanioByIdDispositivo(int idDispositivo);

	@Query("SELECT b FROM Banio b")
	List<Banio> findAllBanios();

	@Query("SELECT b FROM Banio b WHERE FUNCTION('DATE', b.created_at) = :date")
	List<Banio> findBaniosByDate(@Param("date") Date date);

	@Query("SELECT b FROM Banio b WHERE b.enabled = (:enabled)")
	List<Banio> findBaniosByEnabled(@Param("enabled") boolean enabled);

	@Query("SELECT b FROM Banio b WHERE b.name = (:name)")
	List<Banio> findBaniosByName(@Param("name") String name);

	@Query("SELECT b FROM Banio b WHERE FUNCTION('DATE', b.created_at) = :date AND b.name = (:name)")
	List<Banio> findBaniosByDateAndName(@Param("date") Date date, @Param("name") String name);

}

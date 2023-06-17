package com.grupo14.oob2.repositories;

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
	
	@Query("SELECT e FROM Estacionamiento e")
	List<Dispositivo> findAllEstacionamientos();

	@Query("SELECT e FROM Estacionamiento e WHERE DATE(e.created_at) = (:date)")
	List<Estacionamiento> findEstacionamientosByDate(@Param("date") LocalDate date);

	@Query("SELECT e FROM Estacionamiento e WHERE e.enabled = (:enabled)")
	List<Estacionamiento> findEstacionamientosByEnabled(@Param("enabled") boolean enabled);
	
	//Funciones Baño
	//Revisar si mantener este metodo o no
	@Query("SELECT b FROM Banio b WHERE b.enabled = (:enabled)")
	List<Banio> findBaniosByEnabled(@Param("enabled") boolean enabled);
	
	@Query("SELECT b FROM Banio b")
	List<Banio> findAllBanios();
	
	@Query("SELECT b FROM Banio b WHERE FUNCTION('DATE', b.created_at) = :date")
	List<Banio> findBaniosByDate(@Param("date") Date date);

	@Query("SELECT b FROM Banio b WHERE b.name = (:name)")
	List<Banio> findBaniosByName(@Param("name") String name);

	@Query("SELECT b FROM Banio b WHERE FUNCTION('DATE', b.created_at) = :date AND b.name = (:name)")
	List<Banio> findBaniosByDateAndName(@Param("date") Date date, @Param("name") String name);
}

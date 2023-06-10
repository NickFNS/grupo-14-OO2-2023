package com.grupo14.oob2.repositories;

import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Estacionamiento;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {

	@Query("SELECT e FROM Estacionamiento e")
	List<Dispositivo> findAllEstacionamientos();

	// List de Estacionamiento o de Dispositivo?
	@Query("SELECT e FROM Estacionamiento e WHERE DATE(e.created_at) = (:date)")
	List<Estacionamiento> findEstacionamientosByDate(@Param("date") LocalDate date);

	@Query("SELECT e FROM Estacionamiento e WHERE e.enabled = (:enabled)")
	List<Estacionamiento> findEstacionamientosByEnabled(@Param("enabled") boolean enabled);

}

package com.grupo14.oob2.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo14.oob2.entities.Estacionamiento;
import com.grupo14.oob2.entities.Medicion;
import com.grupo14.oob2.entities.MedicionEstacionamiento;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Integer> {

	// TODO: Revisar si se puede hacer con JPA O Scrud Repository

	public abstract Medicion findByIdMedicion(int idMedicion);

	@Query("SELECT m FROM Medicion m JOIN FETCH m.dispositivo d WHERE d.idDispositivo = (:idDispositivo)")
	List<Medicion> findMedicionByDispositivo(@Param("idDispositivo") int idDispositivo);

	@Query("SELECT m FROM Medicion m WHERE TIME(m.registryDateTime) = (:time)")
	List<Medicion> findMedicionByHora(@Param("time") LocalTime time);

	@Query("SELECT m FROM Medicion m WHERE DATE(m.registryDateTime) = (:date)")
	List<Medicion> findMedicionByFecha(@Param("date") LocalDate date);
	
	// ESTACIONAMIENTOS
	@Query("SELECT m FROM MedicionEstacionamiento m ")
	List<MedicionEstacionamiento> getAllMedicionEstacionamiento();
	
	@Query("SELECT m FROM MedicionEstacionamiento m WHERE m.dispositivo = :estacionamiento ORDER BY m.registryDateTime DESC")
	List<MedicionEstacionamiento> findUltimaMedicionEstacionamiento(@Param("estacionamiento") Estacionamiento estacionamiento);

}

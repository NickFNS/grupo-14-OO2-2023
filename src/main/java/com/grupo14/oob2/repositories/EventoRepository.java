package com.grupo14.oob2.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo14.oob2.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

	//TODO: Revisar si se puede hacer con JPA O Scrud Repository


	public abstract Evento findByIdEvento(int idEvento);

	public abstract Evento findByDescription(String description);

	@Query("SELECT e FROM Evento e JOIN FETCH e.dispositivo d WHERE d.idDispositivo = (:idDispositivo)")
	List<Evento> findEventosByDispositivo(@Param("idDispositivo") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE TIME(e.dateTime) = (:time)")
	List<Evento> findEventosByHora(@Param("time") LocalTime time);

	@Query("SELECT e FROM Evento e WHERE DATE(e.dateTime) = :date")
	List<Evento> findEventosByFecha(@Param("date") LocalDate date);
}

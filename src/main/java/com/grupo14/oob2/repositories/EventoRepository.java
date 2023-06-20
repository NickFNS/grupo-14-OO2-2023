package com.grupo14.oob2.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo14.oob2.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

	// TODO: Revisar si se puede hacer con JPA O Scrud Repository

	public abstract Evento findByIdEvento(int idEvento);

	public abstract Evento findByDescription(String description);

	@Query("SELECT e FROM Evento e JOIN FETCH e.dispositivo d WHERE d.idDispositivo = (:idDispositivo)")
	List<Evento> findEventosByDispositivo(@Param("idDispositivo") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE TIME(e.dateTime) = (:time)")
	List<Evento> findEventosByHora(@Param("time") LocalTime time);

	@Query("SELECT e FROM Evento e WHERE DATE(e.dateTime) = :date")
	List<Evento> findEventosByFecha(@Param("date") LocalDate date);

	// Busqueda por tipo:
	List<Evento> findByDispositivoType(String type);

	List<Evento> findByDispositivoTypeOrderByIdEventoDesc(String type);

	// Filtros avanzados por type, fecha, date y description:
	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND DATE(e.dateTime) = :date AND e.dispositivo.idDispositivo = :idDispositivo AND e.description LIKE %:description% ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDateAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(
			@Param("type") String type, @Param("date") Date date, @Param("idDispositivo") int idDispositivo,
			@Param("description") String description);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND DATE(e.dateTime) = :date AND e.dispositivo.idDispositivo = :idDispositivo ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDateAndDispositivoIdOrderByIdEventoDesc(@Param("type") String type,
			@Param("date") Date date, @Param("idDispositivo") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND DATE(e.dateTime) = :date AND e.description LIKE %:description% ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDateAndDescriptionContainingOrderByIdEventoDesc(@Param("type")String type, @Param("date") Date date, @Param("description") String description);
	
	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND e.dispositivo.idDispositivo = :idDispositivo AND e.description LIKE %:description% ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(@Param("type") String type,
			@Param("idDispositivo") int idDispositivo, @Param("description") String description);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND DATE(e.dateTime) = :date ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDateOrderByIdEventoDesc(@Param("type") String type, @Param("date") Date date);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND e.dispositivo.idDispositivo = :idDispositivo ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDispositivoIdOrderByIdEventoDesc(@Param("type") String type,
			@Param("idDispositivo") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE e.dispositivo.type = :type AND e.description LIKE %:description% ORDER BY e.idEvento DESC")
	List<Evento> findByTypeAndDescriptionContainingOrderByIdEventoDesc(@Param("type") String type,
			@Param("description") String description);
}

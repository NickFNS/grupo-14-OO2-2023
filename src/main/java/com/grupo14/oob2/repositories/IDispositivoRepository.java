package com.grupo14.oob2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo14.oob2.entities.Dispositivo;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {

	// @Query("SELECT d FROM Dispositivo d JOIN FETCH d.eventos WHERE d.nombre =
	// (:nombre)")
	// public abstract Dispositivo
	// findByNombreAndFetchEventosEagerly(@Param("nombre") String nombre);

	@Query("SELECT d FROM Dispositivo d WHERE d.nombre = (:nombre)")
	public abstract Dispositivo findByNombre(@Param("nombre") String nombre);

	@Query("SELECT d FROM Dispositivo d WHERE d.tipo = (:tipo)")
	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> getAll();

	public abstract boolean removeByIdDispositivo(int idDispositivo);

}

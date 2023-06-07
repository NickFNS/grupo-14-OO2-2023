package com.grupo14.oob2.services;

import java.util.List;
import com.grupo14.oob2.entities.Dispositivo;

public interface DispositivoService {

	public abstract Dispositivo findByNombre(String nombre);

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public abstract List<Dispositivo> findByTipoDesc(String tipo);

	public abstract List<Dispositivo> getAll();

	public abstract boolean removeByIdDispositivo(int idDispositivo);

}

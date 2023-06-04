package com.grupo14.oob2.services;

import java.util.List;

import com.grupo14.oob2.entities.Sector;

public interface ISectorService {

	public abstract Sector findByNombre(String nombre);

	public abstract Sector findByIdSector(int idSector);

	public abstract List<Sector> getAll();

	public abstract boolean removeByIdSector(int idSector);

}

package com.grupo14.oob2.services;

import com.grupo14.oob2.entities.DAula;
import com.grupo14.oob2.entities.Sector;

import java.util.List;

public interface SectorService {

	public abstract Sector findByNombre(String nombre);

	public abstract Sector findByIdSector(int idSector);

	public abstract boolean removeByIdSector(int idSector);

	List<DAula> dAulaBySector(int idSector) throws Exception;

	Sector save (Sector sector)throws Exception;

}

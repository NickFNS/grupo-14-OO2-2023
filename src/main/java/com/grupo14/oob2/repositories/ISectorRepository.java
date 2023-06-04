package com.grupo14.oob2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo14.oob2.entities.Sector;

@Repository("sectorRepository")
public interface ISectorRepository extends JpaRepository<Sector, Serializable> {

	public abstract Sector findByNombre(String nombre);
	
	public abstract Sector findByIdSector(int idSector);

	public abstract List<Sector> getAll();
	
	public abstract boolean removeByIdSector(int idSector);
	
}

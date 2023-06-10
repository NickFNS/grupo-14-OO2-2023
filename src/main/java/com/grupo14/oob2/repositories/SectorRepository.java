package com.grupo14.oob2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grupo14.oob2.entities.Sector;

@Repository("sectorRepository")
public interface SectorRepository extends JpaRepository<Sector, Integer> {

	public abstract Sector findByName(String name);

	public abstract Sector findByIdSector(int idSector);

	public abstract boolean removeByIdSector(int idSector);

}

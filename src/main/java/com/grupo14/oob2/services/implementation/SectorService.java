package com.grupo14.oob2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Sector;
import com.grupo14.oob2.repositories.ISectorRepository;
import com.grupo14.oob2.services.ISectorService;

@Service("sectorService")
public class SectorService implements ISectorService {

	@Autowired
	@Qualifier("sectorRepository")
	private ISectorRepository repo;

	@Override
	public Sector findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	@Override
	public Sector findByIdSector(int idSector) {
		return repo.findByIdSector(idSector);
	}

	@Override
	public List<Sector> getAll() {
		return repo.findAll();
	}

	@Override
	public boolean removeByIdSector(int idSector) {
		try {
			repo.deleteById(idSector);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}

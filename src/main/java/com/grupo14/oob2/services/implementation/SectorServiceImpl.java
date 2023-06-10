package com.grupo14.oob2.services.implementation;

import com.grupo14.oob2.repositories.SectorRepository;
import com.grupo14.oob2.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Sector;

@Service("sectorService")
public class SectorServiceImpl implements SectorService {

	@Autowired
	@Qualifier("sectorRepository")
	private SectorRepository sectorRepository;

	@Override
	public Sector findByNombre(String name) {
		return sectorRepository.findByName(name);
	}

	@Override
	public Sector findByIdSector(int idSector) {
		return sectorRepository.findByIdSector(idSector);
	}

	@Override
	public boolean removeByIdSector(int idSector) {
		try {
			sectorRepository.deleteById(idSector);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}

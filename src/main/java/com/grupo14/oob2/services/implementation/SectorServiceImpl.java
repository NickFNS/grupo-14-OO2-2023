package com.grupo14.oob2.services.implementation;

import com.grupo14.oob2.entities.DAula;
import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.repositories.SectorRepository;
import com.grupo14.oob2.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupo14.oob2.entities.Sector;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<DAula> dAulaBySector(int idSector) throws Exception {
		Sector sector = sectorRepository.findByIdSector(idSector);
		List <DAula> aulas = new ArrayList<>();
		if(sector == null)throw new Exception("no existe el sector");
		for (Dispositivo dispositivo: sector.getDispositivos()) {
			if(dispositivo instanceof DAula){
				aulas.add((DAula) dispositivo);
			}
		}
		return aulas;
	}

	@Override
	public Sector save(Sector sector) throws Exception {
		return sectorRepository.save(sector);
	}

}

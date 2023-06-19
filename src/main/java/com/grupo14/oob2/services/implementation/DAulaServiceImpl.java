package com.grupo14.oob2.services.implementation;

import com.grupo14.oob2.entities.DAula;
import com.grupo14.oob2.repositories.DAulaRepository;
import com.grupo14.oob2.services.DAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DAulaServiceImpl implements DAulaService {

    @Autowired
    private DAulaRepository dAulaRepository;

    @Override
    public List<DAula> findAll() {
        return dAulaRepository.findAll();
    }

    @Override
    public DAula findByID(int id) {
        return dAulaRepository.getById(id);
    }

    @Override
    public DAula save(DAula aula) throws Exception {
        return dAulaRepository.save(aula);
    }

    @Override
    public DAula update(DAula aula) throws Exception {
        DAula aulaAux = dAulaRepository.getById(aula.getIdDispositivo());
        if(aulaAux ==  null)throw new Exception("no existe el aula");
        return dAulaRepository.save(aulaAux);
    }

    @Override
    public boolean delete(int idAula) throws Exception {
        DAula aula = dAulaRepository.getById(idAula);
        if(aula ==  null)throw new Exception("no existe el aula");
        aula.setEnabled(false);
        dAulaRepository.save(aula);
        return true;
    }
}

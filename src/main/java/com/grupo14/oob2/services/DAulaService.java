package com.grupo14.oob2.services;

import com.grupo14.oob2.entities.DAula;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DAulaService {
    List<DAula> findAll();

    DAula findByID(int id);

    DAula save(DAula aula)throws Exception;

    DAula update(DAula aula)throws Exception;

    boolean delete(int idAula)throws Exception;


}

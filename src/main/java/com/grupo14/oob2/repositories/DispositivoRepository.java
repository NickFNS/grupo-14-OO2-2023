package com.grupo14.oob2.repositories;


import com.grupo14.oob2.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {

}

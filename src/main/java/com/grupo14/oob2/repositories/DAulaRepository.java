package com.grupo14.oob2.repositories;

import com.grupo14.oob2.entities.DAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DAulaRepository extends JpaRepository<DAula, Integer> {

}

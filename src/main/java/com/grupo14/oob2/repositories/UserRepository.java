package com.grupo14.oob2.repositories;


import com.grupo14.oob2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName (String name);
}

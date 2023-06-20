package com.grupo14.oob2.services;

import com.grupo14.oob2.entities.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {
    public User findById(int id);
    public User findByName(String name);

    public UserDetails loadUserByUsername(String username);


}

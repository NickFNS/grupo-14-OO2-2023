package com.grupo14.oob2.services;

import com.grupo14.oob2.entities.User;



public interface UserService {
    public User findById(int id);
    public User findByName(String name);


}

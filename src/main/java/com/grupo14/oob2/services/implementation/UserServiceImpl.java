package com.grupo14.oob2.services.implementation;

import com.grupo14.oob2.entities.User;
import com.grupo14.oob2.repositories.UserRepository;
import com.grupo14.oob2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByName(String name) {
        return  userRepository.findByName(name);
    }
}

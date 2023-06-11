package com.grupo14.oob2.services.implementation;


import com.grupo14.oob2.entities.Role;
import com.grupo14.oob2.repositories.UserRepository;
import com.grupo14.oob2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.grupo14.oob2.entities.User user = userRepository.findByName(username);
        System.out.println(username + "  repository  " +  user.getName());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return buildUser(user, buildGrantedAuthorities(user.getRole()));
    }

    private org.springframework.security.core.userdetails.User buildUser(com.grupo14.oob2.entities.User user, List<GrantedAuthority> grantedAuthorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPassword(), user.isEnabled(),
                true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
                grantedAuthorities);
    }

    public void saveUser(com.grupo14.oob2.entities.User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    private List<GrantedAuthority> buildGrantedAuthorities(Role userRol) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userRol.getName()));
        return new ArrayList<>(grantedAuthorities);
    }


}

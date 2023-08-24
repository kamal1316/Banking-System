package com.wellsfargo.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.repository.UserRepository;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = repository.findByUserId(userId);
        
        if(user.isActiveStatus()) {
        	return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), new ArrayList<>());
        }
        
        throw new UsernameNotFoundException("Your account is inactive!!");
//        return new org.springframework.security.core.userdetails.User(null, null, new ArrayList<>());
    }
}
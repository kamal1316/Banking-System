package com.wellsfargo.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.Admin;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.repository.AdminRepository;
import com.wellsfargo.onlinebanking.repository.UserRepository;

import java.util.ArrayList;

@Service
public class AdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Admin user = repository.findByUserId(userId);
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), new ArrayList<>());
    }
}
package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.userrepository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Optional<User> getUser(Integer id) {
		return userRepo.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User createUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepo.save(newUser);
	}
}
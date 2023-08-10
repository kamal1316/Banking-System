package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.onlinebanking.entity.User;

public interface IUserService {
	
	Optional<User> getUser(Integer id);
	List<User> getAllUsers();
	User createUser(User newUser);
	
}
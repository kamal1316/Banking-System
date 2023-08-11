package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.User;

public interface IUserService {

	
	User getUser(Integer id);

	List<User> getAllUsers();

	User createUser(User newUser);
  
	void deleteUser(User newUser);
	void deleteUserByID(Integer id);
	void deleteAllUsers();
	User updateUserById(Integer id, User updatedUser);
}
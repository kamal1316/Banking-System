package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;

public interface IUserService {

	
	User getUserByUserId(String userId);

	List<User> getAllUsers();

	User createUser(User newUser) throws UserAlreadyExistsException;
  
	void deleteUser(User newUser);
	void deleteUserByID(Integer id);
	void deleteAllUsers();
	User updateUserById(Integer id, User updatedUser);

	boolean existByUserId(String userId);

	boolean existByAccountNumber(String accountNumber);
}
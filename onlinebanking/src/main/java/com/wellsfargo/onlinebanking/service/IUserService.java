package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;

public interface IUserService {

	
	User getUserByUserId(String userId);

	List<User> getAllUsers();

	User createUser(User newUser) throws UserAlreadyExistsException;
	
  
	void deleteUser(User newUser);
	void deleteUserByID(Integer id);
	void deleteAllUsers();

	boolean existByUserId(String userId);

	boolean existByAccountNumber(String accountNumber);

	User updateUser(User updatedUser);

	void changeActiveStatus(String userId) throws ResourceNotFoundException;
}
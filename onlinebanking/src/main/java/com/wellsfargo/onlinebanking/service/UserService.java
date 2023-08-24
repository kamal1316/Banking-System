package com.wellsfargo.onlinebanking.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User getUserByUserId(String userId) {
		return userRepo.findByUserId(userId);
	}
	
	@Override
	public boolean existByUserId(String userId) {
		return userRepo.existByUserId(userId);
	}
	
	@Override
	public boolean existByAccountNumber(String accountNumber) {
		return userRepo.existByAccountNumber(accountNumber);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User createUser(User newUser) throws UserAlreadyExistsException {
		
		if(userRepo.existByUserId(newUser.getUserId())) {
			throw new UserAlreadyExistsException("User with the same User Id already exists!!");
		}
		if(userRepo.existByAccountNumber(newUser.getAccountNumber())) {
			throw new UserAlreadyExistsException("User with the same Account Number already exists!!");
		}
		
		return userRepo.save(newUser);
	}

	@Override
	public void deleteUser(User newUser) {
		userRepo.delete(newUser);
	}
	
	@Override
	public void deleteUserByID(Integer id) {
		userRepo.deleteById(id);
	}

	@Override
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}

	@Override
	public User updateUser(User updatedUser) {
		User changedUser = userRepo.findByUserId(updatedUser.getUserId());
		
		changedUser.setUserId(updatedUser.getUserId());
		changedUser.setAccountNumber(updatedUser.getAccountNumber());
		changedUser.setPassword(updatedUser.getPassword());
		changedUser.setActiveStatus(updatedUser.isActiveStatus());
		
		return userRepo.save(changedUser);
	}

	@Override
	public void changeActiveStatus(String userId) throws ResourceNotFoundException {
		
		User oldUser = userRepo.findByUserId(userId);
		
		if(oldUser == null) {
			throw new ResourceNotFoundException("User Not Found!!");
		}
		
		oldUser.setActiveStatus(!oldUser.isActiveStatus());
		
		userRepo.save(oldUser);
	}

}
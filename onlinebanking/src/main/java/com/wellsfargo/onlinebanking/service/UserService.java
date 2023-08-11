package com.wellsfargo.onlinebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User getUser(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User createUser(User newUser) {
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
	public User updateUserById(Integer id, User updatedUser) {
		User changedUser = userRepo.findById(id).get();
		
		changedUser.setUserId(updatedUser.getUserId());
		changedUser.setAccountNumber(updatedUser.getAccountNumber());
		changedUser.setPasscode(updatedUser.getPasscode());
		
		return userRepo.save(changedUser);
	}
}
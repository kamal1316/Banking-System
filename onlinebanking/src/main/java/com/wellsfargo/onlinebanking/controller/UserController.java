package com.wellsfargo.onlinebanking.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/users")
public class UserController {
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@Autowired
	UserService service;
	
	@GetMapping("/{userId}")
	public User getUserByUserID(@PathVariable String userId) {
		return service.getUserByUserId(userId);
	}
	
	@PostMapping("/createUser")
	public User createUser(@Validated @RequestBody User newUser) {
		return service.createUser(newUser);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@Validated @RequestBody User newUser) {
		service.deleteUser(newUser);
		return;
	}
	
	@DeleteMapping("/deleteAllUsers")
	public void deleteAllUsers() {
		service.deleteAllUsers();
		return;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		service.deleteUserByID(id);
		return;
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUserById(@PathVariable Integer id, @Validated @RequestBody User updatedUser) {
		return service.updateUserById(id, updatedUser);
	}
}
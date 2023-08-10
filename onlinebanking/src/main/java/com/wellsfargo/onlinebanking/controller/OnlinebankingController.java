package com.wellsfargo.onlinebanking.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class OnlinebankingController {
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@Autowired
	UserService service;
	
	@GetMapping("/{id}")
	public Optional<User> getUserByID(@PathVariable Integer id) {
		return service.getUser(id);
	}
	
	@PostMapping("/createUser")
	public User createUser(@Validated @RequestBody User newUser) {
		return service.createUser(newUser);
	}
	
	
}
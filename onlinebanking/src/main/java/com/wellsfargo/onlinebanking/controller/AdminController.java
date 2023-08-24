package com.wellsfargo.onlinebanking.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.RequestAlreadyExistsException;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.AdminService;
import com.wellsfargo.onlinebanking.service.PersonalDetailsService;
import com.wellsfargo.onlinebanking.service.UserService;
import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Person;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/accountRequests")
	public ResponseEntity<List<Person>> getAllRequests() {
		return ResponseEntity.ok(adminService.getAllRequests());
	}
	
	@PostMapping("/createRequest")
	public ResponseEntity<String> createRequest(@Validated @RequestBody Person newPerson) throws RequestAlreadyExistsException {
		
		try {
			Person createdPerson = adminService.createRequest(newPerson);
		}
		catch(RequestAlreadyExistsException ex) {
			throw new RequestAlreadyExistsException(ex.getMessage());
		}
		
		return ResponseEntity.ok("Account Creation Request successfully generated!!");
	}
	
	@GetMapping("/accountRequests/approveRequest/{requestId}")
	public ResponseEntity<String> approveRequest(@PathVariable int requestId) throws ResourceNotFoundException, UserAlreadyExistsException {
		try {
			adminService.approveRequest(requestId);
		}
		catch(ResourceNotFoundException ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		catch(UserAlreadyExistsException ex) {
			throw new UserAlreadyExistsException(ex.getMessage());
		}
		
		return ResponseEntity.ok("Request Approved");
	}
	
	@DeleteMapping("/accountRequests/rejectRequest/{requestId}")
	public ResponseEntity<String> rejectRequest(@PathVariable int requestId) throws ResourceNotFoundException {
		
		try {
			adminService.rejectRequest(requestId);
		}
		catch(ResourceNotFoundException ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		
		return ResponseEntity.ok("Request Rejected!!");
	}
	
	@GetMapping("/listUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PutMapping("/changeActiveStatus/{userId}")
	public ResponseEntity<String> changeActiveStatus(@PathVariable String userId) throws ResourceNotFoundException {
		try {
			userService.changeActiveStatus(userId);
		}
		catch (ResourceNotFoundException ex) {
			throw new ResourceNotFoundException(ex.getMessage());
		}
		
		return ResponseEntity.ok("Successfuly changed status!!");
	}
	
}

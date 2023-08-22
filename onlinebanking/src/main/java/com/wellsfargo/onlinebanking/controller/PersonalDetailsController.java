package com.wellsfargo.onlinebanking.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.service.PersonalDetailsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/personalDetails")
public class PersonalDetailsController {	
	@Autowired
	PersonalDetailsService service;
	
	@GetMapping("/{userId}")
	public ResponseEntity<PersonalDetails> getPersonalDetailsByUserId(@PathVariable String userId) throws ResourceNotFoundException {
		PersonalDetails personalDetails = service.getPersonalDetails(userId);
	
		if(personalDetails == null) {
			throw new ResourceNotFoundException("Personal Details not found for the userId : " + userId);
		}
		
		return ResponseEntity.ok(personalDetails);
	}
	
	@PostMapping("/createPersonalDetails")
	public PersonalDetails createPersonalDetails(@Validated @RequestBody PersonalDetails newPersonalDetails) throws UserAlreadyExistsException {
		try {
			return service.createPersonalDetails(newPersonalDetails);
		}
		catch(UserAlreadyExistsException ex) {
			throw new UserAlreadyExistsException(ex.getMessage());
		}
	}
	
	@DeleteMapping("/deletePersonalDetails")
	public void deletePersonalDetails(@Validated @RequestBody PersonalDetails newPersonalDetails) {
		service.deletePersonalDetails(newPersonalDetails);
		return;
	}
	
//	@DeleteMapping("/deleteAllPersonalDetails")
//	public void deleteAllPersonalDetails() {
//		service.deleteAllPersonalDetails();
//		return;
//	}
	
	@DeleteMapping("/deletePersonalDetails/{userId}")
	public void deletePersonalDetailsById(@PathVariable Integer userId) {
		service.deletePersonalDetailsByID(userId);
		return;
	}
	
//	@PutMapping("/updatePersonalDetails/{userId}")
//	public PersonalDetails updatePersonalDetailsById(@PathVariable Integer userId, @Validated @RequestBody PersonalDetails updatedPersonalDetails) {
//		return service.updatePersonalDetailsById(userId, updatedPersonalDetails);
//	}

}
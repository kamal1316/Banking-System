package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.BaseSeq;
import com.wellsfargo.onlinebanking.entity.Person;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.RequestAlreadyExistsException;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.repository.BaseSeqRepository;
import com.wellsfargo.onlinebanking.repository.RequestRepository;

@Service
public class AdminService {

	@Autowired
	RequestRepository requestRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonalDetailsService personalDetailsService;
	
	@Autowired	
	AccountService accountService;
	
	@Autowired
	BaseSeqRepository baseSeqRepo;
	
	public List<Person> getAllRequests() {
	
		return requestRepo.findAll();
	}

	public Person createRequest(Person newPerson) throws RequestAlreadyExistsException {
		
		if(requestRepo.existByEmail(newPerson.getEmail())) {
			throw new RequestAlreadyExistsException("Request with the same Email already exists!!");
		}
		
		return requestRepo.save(newPerson);
	}

	public void approveRequest(int requestId) throws ResourceNotFoundException, UserAlreadyExistsException {
		
		Person accountToBeCreated = requestRepo.findById(requestId).get();;
		
		if(accountToBeCreated == null) {
			throw new ResourceNotFoundException("Request Not Found!!");
		}		
		
		try {
			openAccount(accountToBeCreated);
			
			requestRepo.deleteById(requestId);
		}
		catch(UserAlreadyExistsException ex) {
			throw new UserAlreadyExistsException("User already Exists!!");
		}
	}
	
	String generatePassword() {
		int len = 10;
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
		Random  rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; ++i) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		
		return sb.toString();
	}
	
	public Person openAccount( Person newPerson) throws UserAlreadyExistsException {
		
		BaseSeq baseSeq = baseSeqRepo.findAll().get(0);
		
		int accountNumber = baseSeq.getAccountNumber()+1;
		int userId = baseSeq.getUserId()+1;
		
		String password = generatePassword();
		
		User user = new User(String.valueOf(userId), String.valueOf(accountNumber), password, true);
		
		PersonalDetails personalDetails = new PersonalDetails(String.valueOf(userId), newPerson.getName(),newPerson.getEmail(), newPerson.getMobile(), newPerson.getAddress(), newPerson.getGender(), newPerson.getCountry(), newPerson.getFatherName() 
				,newPerson.getAadhaarNumber(), newPerson.getPan());
		
		Account account = new Account(String.valueOf(userId), String.valueOf(accountNumber), newPerson.getName(), 10000, "WFIS0001", "savings", "HYD");
		
		try {
			userService.createUser(user);
		}
		catch(UserAlreadyExistsException ex) {			
			throw new UserAlreadyExistsException(ex.getMessage());
		}
		
		try {
			personalDetailsService.createPersonalDetails(personalDetails);
		}
		catch(UserAlreadyExistsException ex) {
			userService.deleteUser(user);
			throw new UserAlreadyExistsException(ex.getMessage());
		}
		
		try {
			accountService.createAccount(account);
		}
		catch(UserAlreadyExistsException ex) {
			userService.deleteUser(user);
			personalDetailsService.deletePersonalDetails(personalDetails);
			throw new UserAlreadyExistsException(ex.getMessage());
		}
		
		baseSeq.setAccountNumber(accountNumber);
		baseSeq.setUserId(userId);
		baseSeqRepo.save(baseSeq);
		
		return newPerson;
	}
	
	public void rejectRequest(int requestId)  throws ResourceNotFoundException {
		Person accountToBeCreated = requestRepo.findById(requestId).get();;
		
		if(accountToBeCreated == null) {
			throw new ResourceNotFoundException("Request Not Found!!");
		}		
			
		requestRepo.deleteById(requestId);
	}

}

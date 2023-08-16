package com.wellsfargo.onlinebanking.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.PersonalDetailsService;
import com.wellsfargo.onlinebanking.service.UserService;
import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Person;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
	private int baseAccountNumber = 10000;
	private int baseUserId = 4000;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonalDetailsService personalDetailsService;
	
	@Autowired	
	AccountService accountService;
	
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
	
	@PostMapping("/openAccount")
	public Person openAccount(@Validated @RequestBody Person newPerson) {
		int accountNumber = ++baseAccountNumber;
		int userId = ++baseUserId;
		
		String password = generatePassword();
		
		newPerson.setUserId(String.valueOf(userId));
		newPerson.setPassword(password);
		newPerson.setAccountNumber(String.valueOf(accountNumber));
		
		User user = new User(newPerson.getUserId(), newPerson.getAccountNumber(), newPerson.getPassword());
		
		PersonalDetails personalDetails = new PersonalDetails(newPerson.getUserId(), newPerson.getName(),newPerson.getEmail(), newPerson.getMobile(), newPerson.getAddress(), newPerson.getGender(), newPerson.getCountry(), newPerson.getFatherName() 
				,newPerson.getAadhaarNumber(), newPerson.getPan());
		
		Account account = new Account(newPerson.getAccountNumber(), newPerson.getName(), newPerson.getBalance(), newPerson.getIfsc(), newPerson.getAccountType(), newPerson.getBranch());
		
		userService.createUser(user);
		personalDetailsService.createPersonalDetails(personalDetails);
		accountService.createAccount(account);
		
		return newPerson;
	}

}

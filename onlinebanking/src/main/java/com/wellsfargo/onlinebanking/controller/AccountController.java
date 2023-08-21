package com.wellsfargo.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService service;
	
	@GetMapping("/allAccounts")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Account> getAccountByUserId(@PathVariable String userId) throws ResourceNotFoundException {
		
		Account account = service.getAccountByUserId(userId);
		
		if(account == null) {
			throw new ResourceNotFoundException("Account not found for the userId : " + userId);
		}
		
		return ResponseEntity.ok(account);
	}
	
	@PostMapping("/createAccount")
	public Account createAccount(@Validated @RequestBody Account newAccount) throws UserAlreadyExistsException {
		try {
			return service.createAccount(newAccount);
		}
		catch(UserAlreadyExistsException ex) {
			throw new UserAlreadyExistsException(ex.getMessage());
		}
	}
}


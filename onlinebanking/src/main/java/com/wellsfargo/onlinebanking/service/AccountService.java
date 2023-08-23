package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.repository.AccountRepository;

@Service
public class AccountService implements IAccountService{

	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account getAccountByUserId(String userId) {
		return accountRepository.findByUserId(userId);
	}
	
	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	
	@Override
	public Account createAccount(Account newAccount) throws UserAlreadyExistsException {
		
		if(accountRepository.existByUserId(newAccount.getUserId())) {
			throw new UserAlreadyExistsException("User with the same User Id already exists!!");
		}
		
		return accountRepository.save(newAccount);
	}
	
	@Override
	public Account updateAccount(Account updatedAccount) {
		return accountRepository.save(updatedAccount);
	}

}

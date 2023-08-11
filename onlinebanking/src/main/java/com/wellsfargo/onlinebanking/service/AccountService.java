package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.repository.AccountRepository;

@Service
public class AccountService implements IAccountService{

	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Optional<Account> getAccountById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	
	@Override
	public Account createAccount(Account newAccount) {
	
		return accountRepository.save(newAccount);
	}

}

package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;


public interface IAccountService {

	Account createAccount(Account newAccount) throws UserAlreadyExistsException;

	List<Account> getAllAccounts();

	Account getAccountByUserId(String userId);
	
	Account getAccountByAccountNumber(String accountNumber);
	
	Account updateAccount(Account updatedAccount);

}

package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.onlinebanking.entity.Account;


public interface IAccountService {

	Account createAccount(Account newAccount);

	List<Account> getAllAccounts();

	Account getAccountByUserId(String userId);
	
	Account getAccountByAccountNumber(String accountNumber);
	
	Account updateAccount(Account updatedAccount);

}

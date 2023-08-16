package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.Account;


public interface IAccountService {

	Account createAccount(Account newAccount);

	List<Account> getAllAccounts();

	Account getAccountByUserId(String userId);

}

package com.wellsfargo.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.Transaction;
import com.wellsfargo.onlinebanking.service.AccountService;
import com.wellsfargo.onlinebanking.service.TransactionService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transService;

	@Autowired
	AccountService accountService;
	
	@GetMapping("{accountNumber}/transactions")
	public List<Transaction> getTransactions(@PathVariable String accountNumber) {
		return transService.getTransactions(accountNumber, accountNumber); 
	}
	
	@GetMapping("/{refId}")
	public Optional<Transaction> getTransaction(@PathVariable Integer refId) {
		return transService.getTransaction(refId);
	}
	
	@PostMapping("/executeTransaction")
	public String executeTransaction(@Validated @RequestBody Transaction transaction) {

		Account sender = accountService.getAccountByAccountNumber(transaction.getFromAccount());
		Account receiver = accountService.getAccountByAccountNumber(transaction.getToAccount());
		
		if(accountService.getAccountByAccountNumber(transaction.getFromAccount()).getBalance() < transaction.getAmount()) {
//			return "Insufficient Balance";
			throw new Error("Insufficient Balance");
		}
		
		sender.setBalance(sender.getBalance()-transaction.getAmount());
		receiver.setBalance(receiver.getBalance()+transaction.getAmount());
		
		accountService.updateAccount(receiver);
		accountService.updateAccount(sender);
		transService.createTransaction(transaction);
		
		return "successfully transfered";
	}

	
	
}

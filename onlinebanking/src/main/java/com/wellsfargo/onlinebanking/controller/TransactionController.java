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
import com.wellsfargo.onlinebanking.entity.Transaction;
import com.wellsfargo.onlinebanking.entity.Withdraw;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
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
	public ResponseEntity<String> executeTransaction(@Validated @RequestBody Transaction transaction) throws ResourceNotFoundException {

		Account sender = accountService.getAccountByAccountNumber(transaction.getFromAccount());
		Account receiver = accountService.getAccountByAccountNumber(transaction.getToAccount());
		
		if(receiver==null) {
			throw new ResourceNotFoundException("Account doesn't exist for account number : " + transaction.getToAccount());
		}
		
		if(sender == null) {
			throw new ResourceNotFoundException("Account doesn't exist for account number : " + transaction.getFromAccount());
		}
		
		if(sender.getBalance() < transaction.getAmount()) {
			throw new Error("Insufficient Balance!!");
		}

		sender.setBalance(sender.getBalance()-transaction.getAmount());
		receiver.setBalance(receiver.getBalance()+transaction.getAmount());
		
		accountService.updateAccount(receiver);
		accountService.updateAccount(sender);
		transService.createTransaction(transaction);
		
		return ResponseEntity.ok("Successfully transfered");
	}
	
	@PostMapping("/executeWithdraw")
	public ResponseEntity<String> executeWithdraw(@Validated @RequestBody Withdraw withdraw)  {
            
		Account accountHolder = accountService.getAccountByUserId(withdraw.getUserId());
	
		
		if(accountHolder.getBalance() < withdraw.getAmount()) {
			throw new Error("Insufficient Balance!!");
		}

		accountHolder.setBalance(accountHolder.getBalance()-withdraw.getAmount());
		
		accountService.updateAccount(accountHolder);
		
		Transaction transaction = new Transaction();
		transaction.setAmount(withdraw.getAmount());
		transaction.setFromAccount(accountHolder.getAccountNumber());
		transaction.setToAccount(accountHolder.getAccountNumber());
		transaction.setMode("withdraw");
		transaction.setTimestamp(withdraw.getTimestamp());
		transaction.setRemark("");
	
		transService.createTransaction(transaction); 
		
		return ResponseEntity.ok("Successfully Withdrawn");
	}
}

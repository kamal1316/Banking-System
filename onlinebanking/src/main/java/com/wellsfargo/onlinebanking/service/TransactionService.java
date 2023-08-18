package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wellsfargo.onlinebanking.entity.Transaction;
import com.wellsfargo.onlinebanking.repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService {
	
	@Autowired
	TransactionRepository transRepo;
	
	@Override
	public Optional<Transaction> getTransaction(Integer refId) {
		return transRepo.findById(refId);	
	}
	
	@Override
	public List<Transaction> getTransactions(String fromAccount, String toAccount) {
		return transRepo.findByFromAccountOrToAccount(fromAccount, toAccount);
	}
	
	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transRepo.save(transaction);
	}

}

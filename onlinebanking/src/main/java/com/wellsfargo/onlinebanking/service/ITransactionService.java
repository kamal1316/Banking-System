package com.wellsfargo.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.onlinebanking.entity.Transaction;

public interface ITransactionService {
	
	List<Transaction> getTransactions(String fromAccount, String toAccount);
	Transaction createTransaction(Transaction transaction);

	Optional<Transaction> getTransaction(Integer refId);
}

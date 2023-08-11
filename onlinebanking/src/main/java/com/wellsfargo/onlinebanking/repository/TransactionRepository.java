package com.wellsfargo.onlinebanking.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByFromAccountOrToAccount(String fromAccount, String toAccount);
	
	
}

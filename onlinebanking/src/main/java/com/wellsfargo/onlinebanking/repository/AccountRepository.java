package com.wellsfargo.onlinebanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUserId(String userId);
	Account findByAccountNumber(String accountNumber);
}

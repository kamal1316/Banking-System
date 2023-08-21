package com.wellsfargo.onlinebanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wellsfargo.onlinebanking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUserId(String userId);
	Account findByAccountNumber(String accountNumber);
	
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.userId = ?1")
	boolean existByUserId(String userId);
}

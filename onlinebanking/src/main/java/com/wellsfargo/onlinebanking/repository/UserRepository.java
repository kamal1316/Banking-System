package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wellsfargo.onlinebanking.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(String userId);

	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.userId = ?1")
	boolean existByUserId(String userId);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.accountNumber = ?1")
	boolean existByAccountNumber(String accountNumber);
}

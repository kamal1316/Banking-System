package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wellsfargo.onlinebanking.entity.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {

	PersonalDetails findByUserId(String userId);
	
//	@Query("SELECT p FROM PersonalDetails p WHERE p.email = ?1")
	PersonalDetails findByEmail(String email);

	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PersonalDetails p WHERE p.userId = ?1")
	boolean existByUserId(String userId);
}
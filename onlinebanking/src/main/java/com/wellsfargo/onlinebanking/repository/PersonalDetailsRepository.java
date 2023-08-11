package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {

	PersonalDetails findByUserId(String userId);

}
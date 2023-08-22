package com.wellsfargo.onlinebanking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.onlinebanking.entity.VerificationRequest;



public interface OtpRepository extends JpaRepository<VerificationRequest, Integer> {
	VerificationRequest findByEmail(String email);
}
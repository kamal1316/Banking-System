package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByUserId(String userId);
}

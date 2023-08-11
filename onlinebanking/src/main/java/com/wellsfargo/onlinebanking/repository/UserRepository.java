package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

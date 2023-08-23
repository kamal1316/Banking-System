package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.Person;

public interface RequestRepository extends JpaRepository<Person, Integer> {

	boolean existByEmail(String email);

}

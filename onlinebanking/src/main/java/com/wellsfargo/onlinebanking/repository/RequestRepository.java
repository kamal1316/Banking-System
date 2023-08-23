package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wellsfargo.onlinebanking.entity.Person;

public interface RequestRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Person p WHERE p.email = ?1")
	boolean existByEmail(String email);

}

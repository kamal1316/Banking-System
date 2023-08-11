package com.wellsfargo.onlinebanking.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}

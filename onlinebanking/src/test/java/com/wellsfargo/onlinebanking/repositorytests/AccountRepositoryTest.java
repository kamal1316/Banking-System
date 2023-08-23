package com.wellsfargo.onlinebanking.repositorytests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.repository.AccountRepository;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.wellsfargo.onlinebanking.repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest {
	@Autowired
	private AccountRepository accountRepo;
	
	@Test
	public void testAccountRepository_Save_NotNULL() {
		
		Account testAccount = new Account("5006", "20021", "kim", 1000, "WFIS0001", "Savings", "HYD");
		
		Account savedAccount = accountRepo.save(testAccount);
		
		assertNotNull(savedAccount);
	}
	
	@Test
	public void testAccountRepository_Save_Exists() {
		
		assertFalse(accountRepo.existByUserId("5006"));
		
		Account testAccount = new Account("5006", "20021", "kim", 1000, "WFIS0001", "Savings", "HYD");
		
		Account savedAccount = accountRepo.save(testAccount);
		
		assertTrue(accountRepo.existByUserId(savedAccount.getUserId()));
		assertFalse(accountRepo.existByUserId("5007"));
	}
	
	@Test
	public void testAccountRepository_Save_Find() {
		
		Account testAccount = new Account("5006", "20021", "kim", 1000, "WFIS0001", "Savings", "HYD");
		
		Account savedAccount = accountRepo.save(testAccount);
		
		Account foundAccount = accountRepo.findByUserId(testAccount.getUserId());
		assertEquals(foundAccount, savedAccount);
		assertEquals(accountRepo.findByUserId("5007"), null);
		
		Account foundAccount1 = accountRepo.findByAccountNumber(testAccount.getAccountNumber());
		assertEquals(foundAccount1, savedAccount);
		assertEquals(accountRepo.findByAccountNumber("20023"), null);
	}
}

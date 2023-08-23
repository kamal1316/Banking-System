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

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.repository.UserRepository;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.wellsfargo.onlinebanking.repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testUserRepository_Save_NotNULL() {
		
		User testUser = new User("5006", "20021", "weqr1234", true);
		
		User savedUser = userRepo.save(testUser);
		
		assertNotNull(savedUser);
	}
	
	@Test
	public void testUserRepository_Save_Exists() {
		
		assertFalse(userRepo.existByUserId("5006"));
		
		User testUser = new User("5006", "20021", "weqr1234", true);
		
		User savedUser = userRepo.save(testUser);
		
		assertTrue(userRepo.existByUserId(savedUser.getUserId()));
		assertFalse(userRepo.existByUserId("5007"));
		
		assertTrue(userRepo.existByAccountNumber(savedUser.getAccountNumber()));
		assertFalse(userRepo.existByAccountNumber("20022"));
	}
	
	@Test
	public void testUserRepository_Save_Find() {
		
		User testUser = new User("5006", "12345", "weqr1234", true);
		
		User savedUser = userRepo.save(testUser);
		
		User foundUser = userRepo.findByUserId(testUser.getUserId());
		
		assertEquals(foundUser, savedUser);
		assertEquals(userRepo.findByUserId("5007"), null);
	}
}

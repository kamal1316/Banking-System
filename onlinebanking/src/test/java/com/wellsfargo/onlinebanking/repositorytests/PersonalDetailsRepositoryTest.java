package com.wellsfargo.onlinebanking.repositorytests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.repository.PersonalDetailsRepository;



@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.wellsfargo.onlinebanking.repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonalDetailsRepositoryTest {
	@Autowired
	private PersonalDetailsRepository personalDetailsRepo;
	
	@Test
	public void testPersonalDetailsRepository_Save_NotNULL() {
		PersonalDetails testPersonalDetails = new PersonalDetails("1001","kim","s@gmial.com", "709790", "hfsag","male", "INDIA", "adj", "62398", "6527498y");
		
		PersonalDetails savedPersonalDetails = personalDetailsRepo.save(testPersonalDetails);
		assertNotNull(savedPersonalDetails);
	}
	
	@Test
	public void testPersonalDetailsRepository_Find_Equals() {
		
		PersonalDetails testPersonalDetails = new PersonalDetails("1001","kim","s@gmial.com", "7092345790", "hfsag","male", "INDIA", "adj", "623982345678", "ABCDE7498Y");
		
		PersonalDetails savedPersonalDetails = personalDetailsRepo.save(testPersonalDetails);
		
		PersonalDetails foundPersonalDetails = personalDetailsRepo.findByUserId(testPersonalDetails.getUserId());
		assertEquals(foundPersonalDetails, savedPersonalDetails);
		assertEquals(personalDetailsRepo.findByUserId("1002"), null);
	}
	
	@Test
	public void testAccountRepository_Exists_TrueFalse() {
		
		
		PersonalDetails testPersonalDetails = new PersonalDetails("1001","kim","s@gmial.com", "7092345790", "hfsag","male", "INDIA", "adj", "623982345678", "ABCDE7498Y");
		PersonalDetails savedPersonalDetails = personalDetailsRepo.save(testPersonalDetails);
		
		assertTrue(personalDetailsRepo.existByUserId(savedPersonalDetails.getUserId()));
		assertFalse(personalDetailsRepo.existByUserId("5007"));
	}
	
	
}

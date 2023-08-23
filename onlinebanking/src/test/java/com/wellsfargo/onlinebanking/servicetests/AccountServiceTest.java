package com.wellsfargo.onlinebanking.servicetests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.onlinebanking.entity.Account;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.repository.AccountRepository;
import com.wellsfargo.onlinebanking.service.AccountService;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ComponentScan(basePackages = "com.wellsfargo.onlinebanking.service")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AccountServiceTest {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void testAccountService_Save_NotNULL()  {
		
		Account account = new Account("5006", "20021", "kim", 1000, "WFIS0001", "Savings", "HYD");
		
		Account createAccount = null;
		
		try {
			createAccount = accountService.createAccount(account);
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		}
		
		assertNotNull(createAccount);
		
	}
	
	
}

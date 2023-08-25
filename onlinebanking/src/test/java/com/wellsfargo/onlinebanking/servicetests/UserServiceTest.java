package com.wellsfargo.onlinebanking.servicetests;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.repository.UserRepository;
import com.wellsfargo.onlinebanking.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.wellsfargo.onlinebanking.service")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@InjectMocks
	private UserService userService;

    @Mock
    private UserRepository userRepo;
    
    @Before
    public void init() {
    	User newUser = new User("1001", "10001", "qwerty", true);
    	
    	when(userRepo.existByUserId("1001")).thenReturn(false);
    	when(userRepo.existByAccountNumber("10001")).thenReturn(false);
    	
    	when(userRepo.existByUserId("1002")).thenReturn(true);
    	when(userRepo.existByAccountNumber("10002")).thenReturn(true);
    	
    	when(userRepo.save(any(User.class))).thenReturn(newUser);
    	
    	when(userRepo.findByUserId("1001")).thenReturn(newUser);
    	
    	when(userRepo.findByUserId("1002")).thenReturn(null);
    }
    
    @Test
    public void test_save_ok() {
    	User newUser = new User("1001", "10001", "qwerty", true);
    	
    	try {
			User createdUser = userService.createUser(newUser);
			assertEquals(newUser.getUserId(), createdUser.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	verify(userRepo, times(1)).save(any(User.class));
    	verify(userRepo, times(1)).existByUserId("1001");
    	verify(userRepo, times(1)).existByAccountNumber("10001");
    	
    }
    
    @Test
    public void test_save_notOk() {
    	User newUser = new User("1002", "10002", "qwerty", true);
    	
    	try {
			User createdUser = userService.createUser(newUser);
			assertTrue(false);
		} catch (UserAlreadyExistsException e) {
			assertTrue(true);
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
    	
    	verify(userRepo, times(0)).save(any(User.class));
    	verify(userRepo, times(1)).existByUserId("1002");
    	verify(userRepo, times(0)).existByAccountNumber("10002");
    	
    }
    
    
    @Test
    public void test_getUserByUserId_Found() {
    	User userToBeFound = new User("1001", "10001", "qwerty", true);
    	
    	try {
			User existingUser = userService.getUserByUserId("1001");
			assertEquals(userToBeFound.getAccountNumber(), existingUser.getAccountNumber());
		} catch (Exception e) {
			assertTrue(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	verify(userRepo, times(1)).findByUserId("1001");
    }
    
    @Test
    public void test_getUserByUserId_notFound() {
    	
    	try {
			User existingUser = userService.getUserByUserId("1002");
			assertNull(existingUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	verify(userRepo, times(1)).findByUserId("1002");
    	
    }
}

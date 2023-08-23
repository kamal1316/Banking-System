package com.wellsfargo.onlinebanking.servicetests;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.repository.UserRepository;
import com.wellsfargo.onlinebanking.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserServiceTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository mockUserRepo;
    
    @Before
    public void init() {
    	
    }
    
    @Test
    public void testCreateUser() {
//    	User createdUser = new User("1001", "10001", "QWERTY123");
//        
//        when(mockUserRepo.save(any(User.class))).thenReturn(createdUser);
//        
//    	User user = new User("1001", "10001", "QWERTY123");
//
//    	
//    	User result = null;
//    	
//		try {
////			result = mockMvc.createUser(user);
//			// create user
//		} catch (UserAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	assertEquals(result, createdUser);
//    	
//    	verify(mockUserRepo, times(1)).save(any(User.class));
    }
}

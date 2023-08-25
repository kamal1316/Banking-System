package com.wellsfargo.onlinebanking.controllertests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.exception.ResourceNotFoundException;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.service.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.wellsfargo.onlinebanking.controller")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserControllerTest {
	
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@Before
	public void init() {
		User newUser = new User("1001", "10001", "qwerty", true);
		
		try {
			when(userService.createUser(any(User.class))).thenReturn(newUser);
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		when(userService.getUserByUserId("1001")).thenReturn(newUser);
		when(userService.getUserByUserId("1002")).thenReturn(null);
	}
	
	@Test
	public void testCreateUser() {
		
		User newUser = new User("1001", "10001", "qwerty", true);
		
		try {
			mockMvc.perform(post("/users/createUser")
			        .content(om.writeValueAsString(newUser))
			        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$.userId", is("1001")))
			        .andExpect(jsonPath("$.accountNumber", is("10001")))
			        .andExpect(jsonPath("$.activeStatus", is(true)))
			        .andExpect(jsonPath("$.password", is("qwerty")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       try {
			verify(userService, times(1)).createUser(any(User.class));
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUserByUserId() {
				
		try {
			mockMvc.perform(get("/users/1001")
			        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//			        .header(HttpHeaders.AUTHORIZATION, "User eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0MDA1IiwiZXhwIjoxNjkzMTE1MTQwLCJpYXQiOjE2OTI5MzUxNDB9.TxMi0t5foyeGGDv9-SIN1Yq47SsJBvavfDTosBqlCq0"))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$.userId", is("1001")))
			        .andExpect(jsonPath("$.accountNumber", is("10001")))
			        .andExpect(jsonPath("$.activeStatus", is(true)))
			        .andExpect(jsonPath("$.password", is("qwerty")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

       
		verify(userService, times(1)).getUserByUserId("1001");

	}
	
	@Test
	public void testGetUserByUserId_notFound() {
				
		try {
			mockMvc.perform(get("/users/1002")
			        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//			        .header(HttpHeaders.AUTHORIZATION, "User eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0MDA1IiwiZXhwIjoxNjkzMTE1MTQwLCJpYXQiOjE2OTI5MzUxNDB9.TxMi0t5foyeGGDv9-SIN1Yq47SsJBvavfDTosBqlCq0"))
			        .andExpect(status().isNotFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		

       
		verify(userService, times(1)).getUserByUserId("1002");

	}
	
}

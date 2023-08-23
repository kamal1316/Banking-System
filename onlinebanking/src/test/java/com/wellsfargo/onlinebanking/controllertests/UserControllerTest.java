package com.wellsfargo.onlinebanking.controllertests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

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
		User newUser = new User("1001", "10001", "qwerty");
		
		try {
			when(userService.createUser(any(User.class))).thenReturn(newUser);
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	
	@Test
	public void testCreateUser() {
		
		User newUser = new User("1001", "10001", "qwerty");
		
		try {
			mockMvc.perform(post("/createUser")
			        .content(om.writeValueAsString(newUser))
			        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
					.header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0MDAxIiwiZXhwIjoxNjkyOTAyMTYwLCJpYXQiOjE2OTI3MjIxNjB9.m01HB7VATv-3dkAMQYNPlFw-SrBGeJz0auT8tHq2Akk"))
			        /*.andDo(print())*/
			        .andExpect(status().isCreated())
			        .andExpect(jsonPath("$.userId", is("1001")))
			        .andExpect(jsonPath("$.accountNumber", is("10001")))
			        .andExpect(jsonPath("$.password", is("qwerty")));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
}

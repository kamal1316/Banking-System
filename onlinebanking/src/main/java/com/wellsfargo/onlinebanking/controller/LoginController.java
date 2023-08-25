package com.wellsfargo.onlinebanking.controller;

import com.wellsfargo.onlinebanking.entity.*;
import com.wellsfargo.onlinebanking.service.AdminDetailsService;
import com.wellsfargo.onlinebanking.util.JwtUtil;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AdminDetailsService adminDetailsService;
	
	@GetMapping("/")
	public String logIn() {
		return "Logged In Successfully";
	}
	
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserId(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return jwtUtil.generateToken(authRequest.getUserId());
    }
	
	@PostMapping("/authenticateAdmin")
    public String generateTokenAdmin(@RequestBody AuthRequest authRequest) throws Exception {
        
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUserId(), authRequest.getPassword())
//            );
        	UserDetails admin = adminDetailsService.loadUserByUsername(authRequest.getUserId());
        	
        	if(!authRequest.getPassword().equals(admin.getPassword())) {
        		throw new Exception("invlaid username/password !!");
        	}
        	
        
        return jwtUtil.generateToken(authRequest.getUserId());
    }
	
	@GetMapping(value = "/validate")
	public boolean getValidation(@RequestHeader("Authorization") String token){
		token = token.substring(7);
		AuthResponse auth = new AuthResponse();
		
		if(jwtUtil.validateToken(token)) {
			
			System.out.println("Token validated");
			return true;
		}
		else {
			System.out.println("Token NOT validated");
			return false;

	    }
    }
}

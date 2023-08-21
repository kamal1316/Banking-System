package com.wellsfargo.onlinebanking.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.onlinebanking.entity.VerificationRequest;
import com.wellsfargo.onlinebanking.entity.VerificationResponse;



@RestController
@CrossOrigin("http://localhost:3000")

public class OTPVerificationController {
	
	@PostMapping("/sendOtp")
	public boolean generateOTP(@RequestBody String userId) {
		String generatedOtp = Integer.toString((int) Math.floor(1000+Math.random()*9000));
		
		// send mail to user;
		
		// save {userId, otp} in database;
		
		return true;
	}

private boolean validateOTP(String otp) {
	System.out.println("Generated OTP:" + generatedOtp);
	return (generatedOtp==otp);
}

@PostMapping("/verify-otp")
public @ResponseBody VerificationResponse verifyOTP(@RequestBody VerificationRequest request) {
    
	
	boolean isValid= validateOTP(request.getOtp());
	return new VerificationResponse(isValid);
}

}

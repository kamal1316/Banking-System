package com.wellsfargo.onlinebanking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.onlinebanking.entity.VerificationRequest;
import com.wellsfargo.onlinebanking.entity.ForgotPasswordRequest;
import com.wellsfargo.onlinebanking.service.PersonalDetailsService;
import com.wellsfargo.onlinebanking.service.UserService;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/forgotPassword")
public class OTPVerificationController {
	
	@Autowired
	PersonalDetailsService service;

    @PostMapping("/generateOTP")
    public String generateOTP(@Validated @RequestBody String email) {
    	
        return service.generateOtp(email);
    }

    @PostMapping("/verifyOTP")
    public String verifyOTP(@Validated @RequestBody VerificationRequest request) {
        return service.verifyOtp(request);
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@Validated @RequestBody ForgotPasswordRequest request) {
        return service.resetPassword(request);
    }

}

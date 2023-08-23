package com.wellsfargo.onlinebanking.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.ForgotPasswordRequest;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.User;
import com.wellsfargo.onlinebanking.entity.VerificationRequest;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.repository.OtpRepository;
import com.wellsfargo.onlinebanking.repository.PersonalDetailsRepository;
import com.wellsfargo.onlinebanking.repository.UserRepository;
import com.wellsfargo.onlinebanking.repository.PersonalDetailsRepository;

@Service
public class PersonalDetailsService implements IPersonalDetailsService {

	@Autowired
	PersonalDetailsRepository detailsRepo;
	
	@Autowired
	OtpRepository otpRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;

	@Override
	public PersonalDetails getPersonalDetails(String userId) {
		return detailsRepo.findByUserId(userId);
	}

	@Override
	public List<PersonalDetails> getAllPersonalDetails() {
		return detailsRepo.findAll();
	}

	@Override
	public PersonalDetails createPersonalDetails(PersonalDetails newPersonalDetails) throws UserAlreadyExistsException {
		
		if(detailsRepo.existByUserId(newPersonalDetails.getUserId())) {
			throw new UserAlreadyExistsException("User with the same User Id already exists!!");
		}
		
		return detailsRepo.save(newPersonalDetails);
	}

	@Override
	public void deletePersonalDetails(PersonalDetails newPersonalDetails) {
		detailsRepo.delete(newPersonalDetails);
	}
	
	@Override
	public void deletePersonalDetailsByID(Integer id) {
		detailsRepo.deleteById(id);
	}

	@Override
	public void deleteAllPersonalDetails() {
		detailsRepo.deleteAll();
	}
	
	@Override
	public String generateOtp(String email) {
		
		PersonalDetails details = detailsRepo.findByEmail(email);
		
		if (details != null) {
            
            String otp = generateRandomOTP();
            
            VerificationRequest verificationRequest = new VerificationRequest(otp, email);
            
            otpRepo.save(verificationRequest);

            return "OTP sent successfully.";
        } else {
            throw new Error("Email not found!!");
        }
	}

	@Override
	public String verifyOtp(VerificationRequest request) {
		
		
		VerificationRequest savedRequest = otpRepo.findByEmail(request.getEmail());
		
		if(savedRequest == null) {
			throw new Error("Invalid Email!!");
		}
		
		if(savedRequest.getOtp().equals(request.getOtp())) {
            
			otpRepo.delete(savedRequest);
			
            return "OTP verification successful.";
        } else {
            throw new Error("Invalid Otp");
        }
	}

	@Override
	public String resetPassword(ForgotPasswordRequest request) {
		PersonalDetails details = detailsRepo.findByEmail(request.getEmail());
		
        if (details != null) {
        	
        	User oldUser = userRepo.findByUserId(details.getUserId());
            
            User updatedUser = new User (oldUser.getUserId(), oldUser.getAccountNumber(), request.getNewPassword(), oldUser.isActiveStatus());
            
            userService.updateUser(updatedUser);

            return "Password reset successful.";
        } else {
        	throw new Error("Invalid Email!!");
        }
	}
	
	private String generateRandomOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); 
        return Integer.toString(otp);
    }
	
	
//	@Override
//	public PersonalDetails updatePersonalDetailsById(Integer id, PersonalDetails updatedPersonalDetails) {
//		PersonalDetails changedPersonalDetails = userRepo.findById(id).get();
//		
//		changedPersonalDetails.setPersonalDetailsId(updatedPersonalDetails.getPersonalDetails());
//		changedPersonalDetails.setAccountNumber(updatedPersonalDetails.getAccountNumber());
//		changedPersonalDetails.setPasscode(updatedPersonalDetails.getPasscode());
//		
//		return userRepo.save(changedPersonalDetails);
//	}
}
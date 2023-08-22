package com.wellsfargo.onlinebanking.service;

import java.util.List;

import com.wellsfargo.onlinebanking.entity.ForgotPasswordRequest;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.entity.VerificationRequest;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;

public interface IPersonalDetailsService {

	List<PersonalDetails> getAllPersonalDetails();

	PersonalDetails createPersonalDetails(PersonalDetails newPersonalDetails) throws UserAlreadyExistsException;

	void deletePersonalDetails(PersonalDetails newPersonalDetails);

	void deletePersonalDetailsByID(Integer id);

	void deleteAllPersonalDetails();

	//PersonalDetails updatePersonalDetailsById(Integer id, PersonalDetails updatedPersonalDetails);

	PersonalDetails getPersonalDetails(String userId);
	
	String generateOtp(String email);
	String resetPassword(ForgotPasswordRequest request);

	String verifyOtp(VerificationRequest request);
	

}

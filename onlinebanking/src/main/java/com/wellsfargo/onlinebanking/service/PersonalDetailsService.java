package com.wellsfargo.onlinebanking.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.exception.UserAlreadyExistsException;
import com.wellsfargo.onlinebanking.entity.PersonalDetails;
import com.wellsfargo.onlinebanking.repository.PersonalDetailsRepository;
import com.wellsfargo.onlinebanking.repository.UserRepository;
import com.wellsfargo.onlinebanking.repository.PersonalDetailsRepository;

@Service
public class PersonalDetailsService implements IPersonalDetailsService {

	@Autowired
	PersonalDetailsRepository detailsRepo;

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
package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VerificationRequest")
public class VerificationRequest {

	private int id;
	
	private String otp;
	private String email;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public VerificationRequest() {
		super();
	}
	
	public VerificationRequest(String otp, String email) {
		super();
		this.otp = otp;
		this.setEmail(email);
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	public String getOtp() {
		return otp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


}

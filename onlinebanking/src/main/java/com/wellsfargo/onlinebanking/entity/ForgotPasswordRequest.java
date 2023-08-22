package com.wellsfargo.onlinebanking.entity;

public class ForgotPasswordRequest {
	
	private String email;
	
	private String newPassword;

	public ForgotPasswordRequest(String email, String newPassword) {
		super();
		this.email = email;
		this.newPassword = newPassword;
	}

	public ForgotPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	


}

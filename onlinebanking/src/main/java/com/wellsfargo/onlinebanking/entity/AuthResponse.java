package com.wellsfargo.onlinebanking.entity;

public class AuthResponse {

	private String userId;
	private boolean isValid;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthResponse(String userId, boolean isValid) {
		super();
		setUserId(userId);
		setValid(isValid);
	}
	
}

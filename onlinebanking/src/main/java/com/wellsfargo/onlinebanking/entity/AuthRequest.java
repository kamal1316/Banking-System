package com.wellsfargo.onlinebanking.entity;

public class AuthRequest {

	private String userId;
	private String password;
	
	public AuthRequest() {
		super();
	}
	
	public AuthRequest(String userId, String password) {
		super();
		setUserId(userId);
		setPassword(password);
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

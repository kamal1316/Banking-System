package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	private int id;
	private String userId;
	private String accountNumber;
	private String passcode;
	
	public User() {
		super();
	}
	
	public User(String userId, String accountNumber, String passcode) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.passcode = passcode;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	@Column(name = "userId", nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "accountNumber", nullable = false)
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name = "passcode", nullable = false)
	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
}
package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.Pattern;


@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"accountNumber"})})
public class User {
	private int id;
	private String userId;
	
	@Pattern(regexp = "^[0-9]{5}$")
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
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "accountNumber", nullable = false)
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name = "passcode", nullable = false)
	public String getPasscode() {
		return this.passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
}
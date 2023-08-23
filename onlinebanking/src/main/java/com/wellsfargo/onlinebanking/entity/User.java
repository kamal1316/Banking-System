package com.wellsfargo.onlinebanking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.Pattern;


@Entity
@Table(name = "User")
public class User {
	private int id;
	
	private String userId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId", referencedColumnName = "userId")
//	private Account account;
	
	@Pattern(regexp = "^[0-9]{5}$")
	private String accountNumber;
	private String password;
	
	private boolean activeStatus;
	
	public User() {
		super();
	}
	
	public User(String userId, String accountNumber, String password, boolean activeStatus) {
		super();
		setUserId(userId);
		setAccountNumber(accountNumber);
		setPassword(password);
		setActiveStatus(activeStatus);
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	@Column(name = "userId", nullable = false, unique = true)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "accountNumber", nullable = false, unique = true)
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	
}
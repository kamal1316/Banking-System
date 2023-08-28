package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_seq")
public class BaseSeq {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "account_number")
	private int accountNumber;
	
	@Column(name = "user_id")
	private int userId;
	
	

	public BaseSeq() {
		super();
	}

	

	public BaseSeq(int accountNumber, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.userId = userId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}

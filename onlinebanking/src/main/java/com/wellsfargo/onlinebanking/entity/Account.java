package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	int id;
    private String accountNumber;
    private String name;
    private int balance;
    private String IFSC;
	public Account() {
		
		super();
	}
	public Account(String accountNumber, String name, int balance, String ifsc) {
		super();
		this.setAccountNumber(accountNumber);
		this.setName(name);
		this.setBalance(balance);
		this.setIFSC(ifsc);
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	@Column(name = "accountNumber", nullable = false)
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "IFSC", nullable = false)
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String IFSC) {
		this.IFSC = IFSC;
	}
	
	@Column(name = "balance", nullable = false)
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}

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
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Account")
public class Account {
		
	private int id;
	private String userId;
	
//	@OneToOne(mappedBy = "user")
//	private User user;
	
	@Pattern(regexp = "^[0-9]{5}$")
    private String accountNumber;
    
	private String name;
	
	@Min(value = 0)
    private int balance;
    
    private String IFSC;
    private String accountType;
    private String branch;
	
    public Account() {	
		super();
	}
	public Account(String userId, String accountNumber, String name, int balance, String ifsc, String accountType, String branch) {
		super();
		this.setUserId(userId);
		this.setAccountNumber(accountNumber);
		this.setName(name);
		this.setBalance(balance);
		this.setIFSC(ifsc);
		this.setAccountType(accountType);
		this.setBranch(branch);
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
	
	@Column(name = "accountNumber", nullable = false, unique = true)
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
	
	@Column(name = "accountType", nullable = false)
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Column(name = "branch", nullable = false)
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

}

package com.wellsfargo.onlinebanking.entity;

public class Person {
	private String userId;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String gender;
	private String country;
	private String accountNumber;
	private String fatherName;
	private String aadhaarNumber;
	private String pan;
	private int balance;
	private String ifsc;
	private String branch;
	private String accountType;

	
	public Person(String name, String email, String fatherName, String pan, String aadhaarNumber, String mobile, String address, String gender, String country, String accountNumber, String password) {
		super();
		this.setName(name);
		this.setEmail(email);
		this.setFatherName(fatherName);
		this.setAadhaarNumber(aadhaarNumber);
		this.setPan(pan);
		this.setMobile(mobile);
		this.setAddress(address);
		this.setGender(gender);
		this.setCountry(country);
		this.setAccountNumber(accountNumber);
		this.setPassword(password);
		this.setBalance(0);
		this.ifsc = "WFIS000123";
		this.branch = "HYD";
		this.accountType = "Savings";
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		// TODO Auto-generated method stub
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Person")
public class Person {
	private int id;
	
	private String name;
	
	@Email
	private String email;
	
	
	@Pattern(regexp = "^$|^[0-9]{10}$")
	private String mobile;
	
	private String address;
	
	@Pattern(regexp = "^(male|female|other)$")
	private String gender;
	
	private String country;
	
	
	private String fatherName;
	
	@Pattern(regexp = "^$|^[0-9]{12}$")
	private String aadhaarNumber;
	
	@Pattern(regexp = "^$|^[A-Z]{5}[0-9]{4}[A-Z]{1}$")
	private String pan;
	
	
	
	
	
	public Person(String name, @Email String email, @Pattern(regexp = "^$|^[0-9]{10}$") String mobile, String address,
			@Pattern(regexp = "^(male|female|other)$") String gender, String country, String fatherName,
			@Pattern(regexp = "^$|^[0-9]{12}$") String aadhaarNumber,
			@Pattern(regexp = "^$|^[A-Z]{5}[0-9]{4}[A-Z]{1}$") String pan) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.gender = gender;
		this.country = country;
		this.fatherName = fatherName;
		this.aadhaarNumber = aadhaarNumber;
		this.pan = pan;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	
}
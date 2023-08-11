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
@Table(name = "PersonalDetails")
public class PersonalDetails {
	private int id;
	private String userId;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String gender;
	private String country;
	
	public PersonalDetails() {
		super();
	}
	
	public PersonalDetails(String userId, String name, String email, String password, String mobile, String address, String gender, String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.gender = gender;
		this.country = country;
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
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "mobile", nullable = false)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "country", nullable = false)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}

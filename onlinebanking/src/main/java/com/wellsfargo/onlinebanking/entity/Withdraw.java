package com.wellsfargo.onlinebanking.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Withdraw {
	public Withdraw(String userId, @Min(1) int amount, String timestamp) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	private String userId;
	
	@Min(value = 1)
	private int amount;

	private String timestamp;
	
	public Withdraw() {
		super();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}


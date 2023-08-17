package com.wellsfargo.onlinebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Transaction")
public class Transaction {
	
	private Integer refId;
	
	@Pattern(regexp = "^[0-9]{5}$")
	private String fromAccount;
	
	@Pattern(regexp = "^[0-9]{5}$")
	private String toAccount;
	
	private int amount;
	

	private String name;
	
	@Pattern(regexp = "^(ntfs|rtgs|imps)$")
	private String type;
	
	private String timestamp;
	private String remark;
	
	public Transaction() {
		super();
	}
	
	public Transaction(Integer refId, String fromAccount, String toAccount, int amount, String type, String timestamp, String remark, String name) {
		super();
		setRefId(refId);
		setFromAccount(fromAccount);
		setToAccount(toAccount);
		setAmount(amount);
		setType(type);
		setTimestamp(timestamp);
		setRemark(remark);
		setName(name);
	}


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	
	
	@Column(name = "fromAccount", nullable = false)
	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	

	@Column(name = "toAccount", nullable = false)
	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}	

	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	

	@Column(name = "timestamp", nullable = false)
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

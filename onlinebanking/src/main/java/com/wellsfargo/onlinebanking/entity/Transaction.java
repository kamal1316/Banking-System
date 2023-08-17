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
	
//	@Pattern(regexp = "^(ntfs|rtgs|imps$")
//	private String type;
	
	private String transactionDate;
	private String remark;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String fromAccount, String toAccount, int amount, String transactionDate, String remark) {
		super();
//		this.refId = refId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.remark = remark;
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

	@Column(name = "transactionDate", nullable = false)
	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

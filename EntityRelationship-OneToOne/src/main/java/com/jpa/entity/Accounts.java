package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts_tbl")
public class Accounts {
	@Id
	@Column(name = "account_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	@Column(name = "account_type")
	private String accountType; // Deposit (Fixed/Recurring), Saving, Transaction (Checking/Current)

	// getters and setters
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
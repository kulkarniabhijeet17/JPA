package com.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards_tbl")
public class Cards {
	@Id
	@Column(name = "card_number")
	private Long cardNumber; // 16 to 19-digit
	@Column(name = "card_type")
	private String cardType; // Credit, Debit, Forex
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	@Column(name = "cvv_number")
	private Integer cvv;
	@Column(name = "pin")
	private Integer pin;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_number")
	private Accounts accounts;

	// getters and setters
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
}
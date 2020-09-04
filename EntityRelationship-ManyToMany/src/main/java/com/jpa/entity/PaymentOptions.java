package com.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "payments_tbl")
public class PaymentOptions {
	@Id
	@Column(name = "payment_id", unique = true, nullable = false)
	private Long paymentID;
	@Column(name = "payment_type")
	private String paymentType; // credit card, debit card, net banking

	@ManyToMany(targetEntity = UserInfo.class)
	@JoinTable(name = "user_payments_tbl", joinColumns = @JoinColumn(name = "payment_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<UserInfo> userInfo;

	public Long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Long paymentID) {
		this.paymentID = paymentID;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Set<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Set<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}
}
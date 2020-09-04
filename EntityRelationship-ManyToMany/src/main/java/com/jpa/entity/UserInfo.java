package com.jpa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_info_tbl")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private String userID;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "middle_initial")
	private String middleInitial;
	@Column(name = "dob")
	private String dob;
	@Column(name = "email_id")
	private String emailID;

	@ManyToMany(targetEntity = PaymentOptions.class)
	@JoinTable(name = "user_payments_tbl", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "payment_id"))
	private Set<PaymentOptions> paymentOptions;

	@Override
	public String toString() {
		// return String.format("UserInfo[id=%d, firstName='%s', lastName='%s']", userID, firstName, lastName);
		return String.format("UserInfo[userID='%s', firstName='%s', lastName='%s']", userID, firstName, lastName);
	}

	// getters and setters
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Set<PaymentOptions> getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(Set<PaymentOptions> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
}
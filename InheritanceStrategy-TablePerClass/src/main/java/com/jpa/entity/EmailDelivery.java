package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_delivery_tbl")
public class EmailDelivery extends UserInfo {
	private static final long serialVersionUID = 1L;

	@Column(name = "email_address")
	private String emailAddress;

	// getters and setters
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
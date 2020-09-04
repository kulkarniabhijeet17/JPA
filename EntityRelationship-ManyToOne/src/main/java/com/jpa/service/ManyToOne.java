package com.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.Address;
import com.jpa.entity.UserInfo;

public class ManyToOne {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			// Create UserInfo Entity
			UserInfo userInfo = new UserInfo();
			userInfo.setUserID("Abhijeet27");
			userInfo.setFirstName("Abhijeet");
			userInfo.setLastName("Kulkarni");
			userInfo.setMiddleInitial("R");
			userInfo.setDob("27/11/1989");
			userInfo.setEmailID("kulkarniabhijeet17@gmail.com");

			// Store UserInfo
			entityManager.persist(userInfo);

			// Create Address1 Entity
			Address address1 = new Address();
			address1.setAddressType('P');
			address1.setAddressLine1("Karan Palm");
			address1.setAddressLine2("Opposite to Silver Links");
			address1.setZipCode("402506");
			address1.setStateCode("MH");
			address1.setCountryCode("IND");
			address1.setUserInfo(userInfo);

			// Create Address2 Entity
			Address address2 = new Address();
			address2.setAddressType('C');
			address2.setAddressLine1("Groovee Heights");
			address2.setAddressLine2("Near National Park");
			address2.setZipCode("201304");
			address2.setStateCode("UP");
			address2.setCountryCode("IND");
			address2.setUserInfo(userInfo);

			// Store Addresses
			entityManager.persist(address1);
			entityManager.persist(address2);

			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}

		entityManager.close();
		emfactory.close();
	}
}
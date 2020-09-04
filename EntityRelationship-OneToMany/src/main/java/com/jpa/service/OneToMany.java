package com.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.Address;
import com.jpa.entity.UserInfo;

public class OneToMany {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			// Create Address1 Entity
			Address address1 = new Address();
			address1.setAddressType('P');
			address1.setAddressLine1("Opposite to Costa-Rica");
			address1.setAddressLine1("Near Omega Paradise");
			address1.setZipCode("402506");
			address1.setStateCode("MH");
			address1.setCountryCode("IND");

			// Create Address2 Entity
			Address address2 = new Address();
			address2.setAddressType('C');
			address2.setAddressLine1("Wall Street");
			address2.setAddressLine1("Near Olive Heights");
			address2.setZipCode("201304");
			address2.setStateCode("UP");
			address2.setCountryCode("IND");

			// Store Addresses
			entityManager.persist(address1);
			entityManager.persist(address2);

			List<Address> addressList = new ArrayList<Address>();
			addressList.add(address1);
			addressList.add(address2);

			// Create UserInfo Entity
			UserInfo userInfo = new UserInfo();
			userInfo.setUserID("Abhijeet27");
			userInfo.setFirstName("Abhijeet");
			userInfo.setLastName("Kulkarni");
			userInfo.setMiddleInitial("R");
			userInfo.setDob("27/11/1989");
			userInfo.setEmailID("kulkarniabhijeet17@gmail.com");
			userInfo.setAddressList(addressList);

			// Store UserInfo
			entityManager.persist(userInfo);

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
package com.jpa.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.PaymentOptions;
import com.jpa.entity.UserInfo;

public class ManyToMany {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			// Create PaymentOptions Entity
			PaymentOptions paymentOptions1 = new PaymentOptions();
			paymentOptions1.setPaymentID(new Long(765786968L));
			paymentOptions1.setPaymentType("C");
			paymentOptions1.setUserInfo(null);

			PaymentOptions paymentOptions2 = new PaymentOptions();
			paymentOptions2.setPaymentID(new Long(345786968L));
			paymentOptions2.setPaymentType("D");
			paymentOptions2.setUserInfo(null);

			PaymentOptions paymentOptions3 = new PaymentOptions();
			paymentOptions3.setPaymentID(new Long(165786968L));
			paymentOptions3.setPaymentType("N");
			paymentOptions3.setUserInfo(null);

			// Store PaymentOptions
			entityManager.persist(paymentOptions1);
			entityManager.persist(paymentOptions2);
			entityManager.persist(paymentOptions3);

			// Create PaymentOptions Set1
			Set<PaymentOptions> paymentOptionsSet1 = new HashSet<PaymentOptions>();
			paymentOptionsSet1.add(paymentOptions1);
			paymentOptionsSet1.add(paymentOptions2);
			paymentOptionsSet1.add(paymentOptions3);

			// Create PaymentOptions Set2
			Set<PaymentOptions> paymentOptionsSet2 = new HashSet<PaymentOptions>();
			paymentOptionsSet2.add(paymentOptions3);
			paymentOptionsSet2.add(paymentOptions1);
			paymentOptionsSet2.add(paymentOptions2);

			// Create PaymentOptions Set3
			Set<PaymentOptions> paymentOptionsSet3 = new HashSet<PaymentOptions>();
			paymentOptionsSet3.add(paymentOptions2);
			paymentOptionsSet3.add(paymentOptions3);
			paymentOptionsSet3.add(paymentOptions1);

			// Create Cardholder Entity
			UserInfo userInfo1 = new UserInfo();
			userInfo1.setUserID("Abhijeet24");
			userInfo1.setFirstName("Abhijeet");
			userInfo1.setLastName("Kulkarni");
			userInfo1.setMiddleInitial("R");
			userInfo1.setDob("27/11/1989");
			userInfo1.setEmailID("kulkarniabhijeet17@gmail.com");
			userInfo1.setPaymentOptions(paymentOptionsSet1);

			UserInfo userInfo2 = new UserInfo();
			userInfo2.setUserID("Saurav08");
			userInfo2.setFirstName("Saurav");
			userInfo2.setLastName("Ganguly");
			userInfo2.setMiddleInitial("C");
			userInfo2.setDob("08/07/1973");
			userInfo2.setEmailID("scganguly@gmail.com");
			userInfo2.setPaymentOptions(paymentOptionsSet1);

			UserInfo userInfo3 = new UserInfo();
			userInfo3.setUserID("Rahul10");
			userInfo3.setFirstName("Rahul");
			userInfo3.setLastName("Dravid");
			userInfo3.setMiddleInitial("S");
			userInfo3.setDob("10/01/1973");
			userInfo3.setEmailID("rsdravid@gmail.com");
			userInfo3.setPaymentOptions(paymentOptionsSet1);

			// Store Cardholder
			entityManager.persist(userInfo1);
			entityManager.persist(userInfo2);
			entityManager.persist(userInfo3);

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
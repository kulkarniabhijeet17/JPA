package com.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.EmailDelivery;
import com.jpa.entity.PhysicalDelivery;

public class RequestNewCardDeliveryOptions {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			// Physical delivery entity
			PhysicalDelivery pd1 = new PhysicalDelivery();
			pd1.setUserID("Abhijeet27");
			pd1.setFirstName("Abhijeet");
			pd1.setLastName("Kulkarni");
			pd1.setMiddleInitial("R");
			pd1.setDob("27/11/1989");
			pd1.setEmailID("kulkarniabhijeet17@gmail.com");
			pd1.setAddressLine1("Shonest Tower");
			pd1.setAddressLine2("Near Costa-Rica");
			pd1.setZipCode(411057);

			PhysicalDelivery pd2 = new PhysicalDelivery();
			pd2.setUserID("Saurav08");
			pd2.setFirstName("Saurav");
			pd2.setLastName("Gangulay");
			pd2.setMiddleInitial("C");
			pd2.setDob("08/07/1973");
			pd2.setEmailID("scganguly@gmail.com");
			pd2.setAddressLine1("Deccan Road");
			pd2.setAddressLine2("Near Groove Heights");
			pd2.setZipCode(411057);

			// Email delivery entity
			EmailDelivery ed1 = new EmailDelivery();
			ed1.setUserID("Rahul10");
			ed1.setFirstName("Rahul");
			ed1.setLastName("Dravid");
			ed1.setMiddleInitial("S");
			ed1.setDob("10/01/1973");
			ed1.setEmailID("rsdravid@gmail.com");
			ed1.setEmailAddress("rsdravid@gmail.com");

			EmailDelivery ed2 = new EmailDelivery();
			ed2.setUserID("Sachin24");
			ed2.setFirstName("Sachin");
			ed2.setLastName("Tendulkar");
			ed2.setMiddleInitial("R");
			ed2.setDob("24/04/1974");
			ed2.setEmailID("srtendulkar@gmail.com");
			ed2.setEmailAddress("srtendulkar@gmail.com");

			// storing all entities
			entityManager.persist(pd1);
			entityManager.persist(pd2);
			entityManager.persist(ed1);
			entityManager.persist(ed2);

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
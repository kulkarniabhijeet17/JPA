package com.jpa.service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.Accounts;
import com.jpa.entity.Cards;

public class OneToOne {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			// Create Accounts Entity
			Accounts accounts = new Accounts();
			accounts.setAccountType("S");

			// Store Accounts
			entityManager.persist(accounts);

			// Create Cards Entity
			Cards cards = new Cards();
			cards.setCardNumber(new Long(4684871343446787L));
			cards.setCardType("D");
			cards.setExpirationDate(LocalDateTime.of(2025, 11, 6, 6, 30, 40, 50000));
			cards.setCvv(184);
			cards.setPin(9603);
			cards.setAccounts(accounts);

			// Store Cards
			entityManager.persist(cards);

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
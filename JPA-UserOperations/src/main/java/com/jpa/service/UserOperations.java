package com.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.UserInfo;

public class UserOperations {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			// Add user
			UserInfo userInfo = new UserInfo();
			userInfo.setUserID("Abhijeet27");
			userInfo.setFirstName("Abhijeet");
			userInfo.setLastName("Kulkarni");
			userInfo.setMiddleInitial("R");
			userInfo.setDob("27/11/1989");
			userInfo.setEmailID("kulkarniabhijeet17@gmail.com");

			entityManager.persist(userInfo);
			transaction.commit();

			// Get user
			UserInfo userInfoFetch = entityManager.find(UserInfo.class, "Abhijeet27");
			System.out.println("getUser:: " + userInfoFetch.toString());

			// Update user
			UserInfo userInfoUpdate = entityManager.find(UserInfo.class, "Abhijeet27");
			System.out.println("before updateUser:: " + userInfoUpdate.toString());
			transaction.begin();
			userInfoUpdate.setFirstName("Saurav");
			transaction.commit();
			System.out.println("after updateUser:: " + userInfoUpdate.toString());

			// Delete user
			UserInfo userInfoDelete = entityManager.find(UserInfo.class, "Abhijeet27");
			transaction.begin();
			entityManager.remove(userInfoDelete);
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
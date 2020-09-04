package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.entity.UserInfo;

public class NamedQueriesUserOperations {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("find UserInfo by userID");

		query.setParameter("userID", "Abhijeet24");
		List<UserInfo> list = query.getResultList();

		for (UserInfo e : list) {
			System.out.print("User ID :" + e.getUserID());
			System.out.println("\t User last name :" + e.getLastName());
		}

		entitymanager.close();
		emfactory.close();
	}
}
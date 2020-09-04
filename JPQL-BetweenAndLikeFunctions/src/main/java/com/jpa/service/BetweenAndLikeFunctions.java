package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.entity.UserInfo;

public class BetweenAndLikeFunctions {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");
		EntityManager entitymanager = emfactory.createEntityManager();

		// Between
		Query query = entitymanager
				.createQuery("Select ui " + "from UserInfo ui " + "where ui.salary " + "Between 30000 and 40000");

		List<UserInfo> list = (List<UserInfo>) query.getResultList();

		for (UserInfo ui : list) {
			System.out.print("User ID :" + ui.getUserID());
			System.out.println("\t User salary :" + ui.getLastName());
		}

		// Like
		Query query1 = entitymanager.createQuery("Select ui " + "from UserInfo ui " + "where ui.lastName LIKE 'K%'");

		List<UserInfo> list1 = (List<UserInfo>) query1.getResultList();

		for (UserInfo ui : list1) {
			System.out.print("User ID :" + ui.getUserID());
			System.out.println("\t User last name :" + ui.getLastName());
		}

		entitymanager.close();
		emfactory.close();
	}
}
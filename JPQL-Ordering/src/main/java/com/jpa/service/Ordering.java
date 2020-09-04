package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.entity.UserInfo;

public class Ordering {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");
		EntityManager entitymanager = emfactory.createEntityManager();

		// Order By
		Query query = entitymanager.createQuery("Select ui " + "from UserInfo ui " + "ORDER BY ui.lastName ASC");

		List<UserInfo> list = (List<UserInfo>) query.getResultList();

		for (UserInfo ui : list) {
			System.out.print("User ID :" + ui.getUserID());
			System.out.println("\t User last name :" + ui.getLastName());
		}

		entitymanager.close();
		emfactory.close();
	}
}
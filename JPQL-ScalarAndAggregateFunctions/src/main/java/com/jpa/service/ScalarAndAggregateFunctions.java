package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ScalarAndAggregateFunctions {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emfactory.createEntityManager();

		// Scalar function
		Query query = entityManager.createQuery("Select UPPER(ui.lastName) from UserInfo ui");
		List<String> list = query.getResultList();

		for (String ui : list) {
			System.out.println("Last Name:: " + ui);
		}

		// Aggregate function
		Query query1 = entityManager.createQuery("Select COUNT(ui.salary) from UserInfo ui");
		Double result = (Double) query1.getSingleResult();
		System.out.println("Max value:: " + result);
	}
}
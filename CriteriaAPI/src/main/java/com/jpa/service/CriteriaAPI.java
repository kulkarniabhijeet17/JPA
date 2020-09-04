package com.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jpa.entity.UserInfo;

public class CriteriaAPI {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("HibernatePersistence");

		EntityManager entityManager = emFactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<UserInfo> from = criteriaQuery.from(UserInfo.class);

		// select all records
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entityManager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();

		for (Object obj : resultlist) {
			UserInfo ui = (UserInfo) obj;
			System.out.println("UserID : " + ui.getUserID() + " First name : " + ui.getFirstName());
		}

		// Ordering the records
		CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("firstName")));
		TypedQuery<Object> typedQuery1 = entityManager.createQuery(select);
		List<Object> resultlist1 = typedQuery1.getResultList();

		for (Object obj : resultlist1) {
			UserInfo ui = (UserInfo) obj;
			System.out.println("UserID : " + ui.getUserID() + " First name : " + ui.getFirstName());
		}

		entityManager.close();
		emFactory.close();
	}
}
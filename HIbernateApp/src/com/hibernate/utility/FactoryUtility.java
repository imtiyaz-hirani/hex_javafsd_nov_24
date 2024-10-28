package com.hibernate.utility;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
 import jakarta.persistence.Persistence;

public class FactoryUtility {
	
	static FactoryUtility factoryUtility;
	
	static {
		factoryUtility = new FactoryUtility();
	}
	private FactoryUtility() {  }
	
	public static FactoryUtility getInstance() {
		return factoryUtility;
	}
	public EntityManager loadPersistence() {
		//step 1
		 //from here i need to reach out to persistence.xml : 
		SessionFactory sessionFactory = (SessionFactory)
						Persistence.createEntityManagerFactory("myecomapp");
		//step 2
		EntityManager entityManager =  sessionFactory.createEntityManager();
		
		return entityManager;
	}
}

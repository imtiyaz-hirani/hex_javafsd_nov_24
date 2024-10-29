package com.hibernate.service;

import java.util.List;
import java.util.Scanner;

import com.hibernate.enums.RoleType;
import com.hibernate.exception.ResourceNotFoundException;
import com.hibernate.model.Executive;
import com.hibernate.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ExecutiveService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public ExecutiveService(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entityTransaction = entityManager.getTransaction();
	}

	public Executive takeInputAndGenerateId(Scanner sc) {
		Executive executive = new Executive();
		System.out.println("Enter name");
		sc.nextLine();
		executive.setName(sc.nextLine());
		System.out.println("Enter salary");
		executive.setSalary(sc.nextDouble());
		//gen ID
		int executiveId =(int) (Math.random()*1000000000);
		executive.setId(executiveId);
		
		System.out.println("----Set up credentials for executive----");
		User user = new User();
		System.out.println("Enter username");
		user.setUsername(sc.next());
		System.out.println("Enter temp password");
		user.setPassword(sc.next());
		//set Role
		user.setRole(RoleType.EXECUTIVE);
		user.setPasswordReset(false);
		//get ID
		int userId =(int) (Math.random()*1000000000);
		user.setId(userId);
		
		//attach user to Executive
		executive.setUser(user);
		 
		return executive;
	}

	public void saveExecutiveAnduser(Executive executive) {
		entityTransaction.begin();
		entityManager.persist(executive.getUser());
		entityManager.persist(executive);
		entityTransaction.commit();
		
	}

	public Executive checkLogin(String username,String password) throws ResourceNotFoundException {
		 
		String jpql="select e from Executive e "
				+ " JOIN e.user u "
				+ " where u.username=?1 AND u.password=?2";
		entityTransaction.begin();
		TypedQuery<Executive> query = entityManager.createQuery(jpql,Executive.class);
		query.setParameter(1, username);
		query.setParameter(2, password); 
		List<Executive> list = query.getResultList();
		entityTransaction.commit();
		
		if(list!=null && list.isEmpty())
			throw new ResourceNotFoundException("Invlid Credentials..");
		
		return list.get(0);
	}

}

/*
 *  select e.* 
 *  from executive e JOIN user_info u ON e.user_id = u.id
    where u.username='harry@gmail.com' AND u.password='123456';
    
    select e 
    from Executive e JOIN e.user u 
    where u.username=?1 AND u.password=?2
  
 */
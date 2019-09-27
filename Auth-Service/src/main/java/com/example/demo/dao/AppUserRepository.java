package com.example.demo.dao;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class AppUserRepository extends RepositoryBase<User> {

	public AppUserRepository() {
		super(User.class);
	}
	
	public User getByUsername(String username) {
		Query query = entityManager.createQuery("SELECT e FROM  e user-identity e.username = ?1");
	      query.setParameter(1, username);
	      User resultList =(User) query.getSingleResult();
	    return resultList;
	}
	
	

}

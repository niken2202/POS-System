package com.example.demo.dao;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AppUser;

@Repository
public class AppUserRepository extends RepositoryBase<AppUser> {

	public AppUserRepository() {
		super(AppUser.class);
	}
//	public Iterable<AppUser> getall() {
//
//		Session currentSession = entityManager.unwrap(Session.class);
//		Iterable<AppUser> lists = (Iterable<AppUser>) currentSession.createQuery("from AppUser",AppUser.class).getResultList();
//		return lists;
//	};
	
	public AppUser getByUsername(String username) {
		Query query = entityManager.createQuery("SELECT e FROM  e user-identity e.username = ?1");
	      query.setParameter(1, username);
	      AppUser resultList =(AppUser) query.getSingleResult();
	    return resultList;
	}
	
	

}

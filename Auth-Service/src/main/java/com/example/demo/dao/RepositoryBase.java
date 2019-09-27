package com.example.demo.dao;


import javax.persistence.EntityManager;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class RepositoryBase<T> {
	@Autowired
	protected EntityManager entityManager;
	private Class<T> O;
	public RepositoryBase(Class<T> O) {
		this.O =O;
	}
	public T add(T  enity) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(enity);

		return enity;
	};

	public void delete(T enity) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.delete(enity);

	};
	public Iterable<T> getAll(){
		Session currentSession = entityManager.unwrap(Session.class);
		Iterable<T> lists = (Iterable<T>) currentSession.createQuery("from "+O.getName(),O).getResultList();
		return lists;
	}
	public T findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return (T) currentSession.get(O.getTypeName(),id);
	}

	

}

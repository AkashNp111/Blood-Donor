package com.blood.donors.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
	public  class  BaseDAO<T , ID extends Serializable> {
	
	@PersistenceContext
	private EntityManager entityManager = null;
	
	private Class<T> entityClass ;
	
	public BaseDAO() {
		
	}
	public BaseDAO( Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	public T saveOrUpdate(T entity)
	{
		Session session = entityManager.unwrap(Session.class);
		session.merge(entity);
		session.flush();
		session.close();
		
		return entity;
	}
	
	public T getById(ID id)
	{
		Session session = entityManager.unwrap(Session.class);
		T entity = session.get(entityClass,id);
		session.close();
		return entity;
	}
	
	public T deleteById(ID id)
	{
		Session session = entityManager.unwrap(Session.class);
		T entity = session.get(entityClass,id);
		session.delete(entity);
		session.flush();
		session.close();
		return entity;
	}
	
	public List<T> findAll()
	{
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<T> root = criteriaQuery.from(entityClass);
		criteriaQuery.select(root);
		Query<T> q = session.createQuery(criteriaQuery);
		List<T> list =q.getResultList();
		session.close();
		return list;
				
	}
	

}

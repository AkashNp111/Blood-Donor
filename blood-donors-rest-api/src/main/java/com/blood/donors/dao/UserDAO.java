package com.blood.donors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.blood.donors.controller.bean.Login;
import com.blood.donors.dao.bean.User;

@Repository
public class UserDAO  {
	
	@PersistenceContext
	private EntityManager entityManager = null;
	
	
	public UserDAO() {
		
	}
	
	public User saveOrUpdate(User entity)
	{
		Session session = entityManager.unwrap(Session.class);
		session.merge(entity);
		session.flush();
		session.close();
		
		return entity;
	}
	
	public User getById(String loginId)
	{
		Session session = entityManager.unwrap(Session.class);
		User entity = session.get(User.class,loginId);
		session.close();
		return entity;
	}
	
	public User deleteById(String id)
	{
		Session session = entityManager.unwrap(Session.class);
		User entity = session.get(User.class,id);
		entity.setRoleSet(null);
		
		session.delete(entity);
		session.flush();
		session.close();
		return entity;
	}
	
	public List<User> findAll()
	{
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		Query<User> q = session.createQuery(criteriaQuery);
		List<User> list =q.getResultList();
		session.close();
		return list;
				
	}
	
	public User validateUserLogin(Login login)
	{
		String hql = " Select usr From User usr Where upper(usr.loginId) = :loginId and usr.password = :password ";
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<User>  query = session.createQuery(hql, User.class);
		query.setParameter("loginId", login.getLoginId().toUpperCase().trim());
		query.setParameter("password", login.getPassword());
		List<User> usersList =  query.getResultList();
		return usersList.size() > 0 ? usersList.get(0): null ;
	}
}

package com.blood.donors.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.blood.donors.dao.bean.Role;

@Repository
public class RoleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;	
	
		public Role test()
		{
			Session session = entityManager.unwrap(Session.class);
			return session.get(Role.class, 1);
					
		}

}

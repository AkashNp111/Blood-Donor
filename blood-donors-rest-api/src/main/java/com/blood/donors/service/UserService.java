package com.blood.donors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blood.donors.controller.bean.Login;
import com.blood.donors.dao.UserDAO;
import com.blood.donors.dao.bean.User;

@Service	
public class UserService {

	@Autowired
	private UserDAO userDAO = null;

	@Transactional
	public User saveOrUpdate(User entity) {

		return userDAO.saveOrUpdate(entity);
	}

	public User getById(String loginId) {

		return userDAO.getById(loginId);	
	}

	@Transactional
	public User deleteById(String id) {

		return userDAO.deleteById(id);
	}

	public List<User> findAll() {

		return userDAO.findAll();

	}
	
	public User validateUserLogin(Login login)
	{
		return userDAO.validateUserLogin(login);
	}
}

package com.blood.donors.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blood.donors.dao.BaseDAO;

@Service		
public  class BaseService<T, ID extends Serializable> {

	@Autowired
	private BaseDAO<T, Serializable> baseDAO = null;

	public T saveOrUpdate(T entity) {

		return baseDAO.saveOrUpdate(entity);
	}

	public T getById(ID id) {

		return baseDAO.getById(id);	
	}

	public T deleteById(ID id) {

		return baseDAO.deleteById(id);
	}

	public List<T> findAll() {

		return baseDAO.findAll();

	}
}

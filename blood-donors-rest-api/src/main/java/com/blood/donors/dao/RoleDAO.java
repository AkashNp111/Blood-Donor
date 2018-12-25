package com.blood.donors.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.blood.donors.dao.bean.Role;

@Repository
public class RoleDAO  extends BaseDAO<Role, Serializable>{
	
	public RoleDAO()
	{
		super(Role.class);
	}
	
}

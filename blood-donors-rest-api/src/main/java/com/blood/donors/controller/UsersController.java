package com.blood.donors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blood.donors.dao.RoleDAO;
import com.blood.donors.dao.bean.Role;

@RestController
public class UsersController {
	
	@Autowired
	private RoleDAO roleDAO;
	
	@GetMapping(path="/users")
	public ResponseEntity<Role> loadUsers()
	{
		return new ResponseEntity<Role>(roleDAO.test(),HttpStatus.OK);
	}

}

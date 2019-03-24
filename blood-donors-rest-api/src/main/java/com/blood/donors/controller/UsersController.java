package com.blood.donors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blood.donors.controller.bean.Login;
import com.blood.donors.controller.bean.UserControllerBean;
import com.blood.donors.dao.bean.Address;
import com.blood.donors.dao.bean.User;
import com.blood.donors.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/users")
	public ResponseEntity<List<User>> loadUsers()
	{
		return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/users/{loginId}")
	public ResponseEntity<User> findUserByLoginId(@PathVariable("loginId") String loginId)
	{
		return new ResponseEntity<User>(userService.getById(loginId),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/users/{loginId}")
	public ResponseEntity<User> deleteUserByLoginId(@PathVariable("loginId") String loginId)
	{
		return new ResponseEntity<User>(userService.deleteById(loginId),HttpStatus.OK);
	}
	
	

	@PostMapping(path="/users",consumes="application/json")
	public ResponseEntity<User> saveUser(@RequestBody UserControllerBean controllerBean)
	{
		Address address = new Address(controllerBean.getLoginId(),
				controllerBean.getAddress().getCity(),
				controllerBean.getAddress().getState(), 
				controllerBean.getAddress().getLoaction());
		User user = new User(
				controllerBean.getLoginId(),
				controllerBean.getPassword(), 
				controllerBean.getFirstName(), 
				controllerBean.getLastName(), 
				controllerBean.getEmailId(), 
				controllerBean.getBloodGroup(), 
				controllerBean.getMobileNo(), 
				address);
		return new ResponseEntity<User>(userService.saveOrUpdate(user),HttpStatus.OK);
	}
	
	@PostMapping(path="/login",consumes="application/json")
	public ResponseEntity<User> userLogin(@RequestBody Login login)
	{
		return new ResponseEntity<User>(userService.validateUserLogin(login),HttpStatus.OK);
	}
	
	@PutMapping(path="/users",consumes="application/json")
	public ResponseEntity<User> updateUser(@RequestBody UserControllerBean controllerBean)
	{
		Address address = new Address(controllerBean.getLoginId(),
				controllerBean.getAddress().getCity(),
				controllerBean.getAddress().getState(), 
				controllerBean.getAddress().getLoaction());
		User user = new User(
				controllerBean.getLoginId(),
				controllerBean.getPassword(), 
				controllerBean.getFirstName(), 
				controllerBean.getLastName(), 
				controllerBean.getEmailId(), 
				controllerBean.getBloodGroup(), 
				controllerBean.getMobileNo(), 
				address);
		return new ResponseEntity<User>(userService.saveOrUpdate(user),HttpStatus.OK);
	}
}

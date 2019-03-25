package com.blood.donors.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "USERS_ADDRESS")
public class Address {
	
	@Id
	@Column(name = "LOGIN_ID")
	private String loginId = null;

	@Column(name = "CITY")
	private String city = null;

	@Column(name = "STATE")
	private String state = null;

	@Column(name = "LOCATION")
	private String location = null;


	public Address() {

	}
	
	

	public Address(String loginId, String city, String state, String loaction) {
		super();
		this.loginId = loginId;
		this.city = city;
		this.state = state;
		this.location = loaction;
	}



	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}

	

	
}

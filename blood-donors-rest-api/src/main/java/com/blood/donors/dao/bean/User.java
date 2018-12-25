package com.blood.donors.dao.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GenericGenerator(name = "asg", strategy = "assigned")
	@GeneratedValue(generator = "asg")
	@Column(name = "LOGIN_ID")
	private String loginId = null;

	@Column(name = "PASSWORD")
	private String password = null;

	@Column(name = "FIRST_NAME")
	private String firstName = null;

	@Column(name = "LAST_NAME")
	private String lastName = null;

	@Column(name = "EMAIL_ID")
	private String emailId = null;

	@Column(name = "BLOOD_GROUP")
	private String bloodGroup = null;

	@Column(name = "MOBILE_NO")
	private String mobileNo = null;

	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Address address = null;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_ROLE", joinColumns = { @JoinColumn(name = "LOGIN_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roleSet = null;

	@OneToMany(fetch = FetchType.EAGER,mappedBy="postedUser")
	@Fetch(FetchMode.SUBSELECT)
	private Set<Feedback> postedFeedbacks = null;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="donor")
	@Fetch(FetchMode.SUBSELECT)
	private Set<Feedback> donorsSet = null;
	
	
	public User() {

	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public Set<Feedback> getPostedFeedbacks() {
		return postedFeedbacks;
	}

	public void setPostedFeedbacks(Set<Feedback> postedFeedbacks) {
		this.postedFeedbacks = postedFeedbacks;
	}

	public Set<Feedback> getDonorsSet() {
		return donorsSet;
	}

	public void setDonorsSet(Set<Feedback> donorsSet) {
		this.donorsSet = donorsSet;
	}

}

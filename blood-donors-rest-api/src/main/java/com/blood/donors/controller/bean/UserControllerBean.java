package com.blood.donors.controller.bean;

public class UserControllerBean {

	private String loginId = null;

	private String password = null;

	private String firstName = null;

	private String lastName = null;

	private String emailId = null;

	private String bloodGroup = null;

	private String mobileNo = null;

	private AddressControllerBean address = null;

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

	public AddressControllerBean getAddress() {
		return address;
	}

	public void setAddress(AddressControllerBean address) {
		this.address = address;
	}

}

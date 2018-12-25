package com.blood.donors.dao.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@Column(name = "Role_ID")
	private Integer roleId;

	@Column(name = "Role_Name")
	private String roleName;

	@ManyToMany(fetch=FetchType.EAGER,mappedBy = "roleSet")
	@JsonBackReference
	private Set<User> userSet = null;

	public Role() {

	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

}

package com.codingz.simplebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ROLE_MAPPING")
	private String roleMapping;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	// set get method
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleMapping() {
		return roleMapping;
	}
	public void setRoleMapping(String roleMapping) {
		this.roleMapping = roleMapping;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
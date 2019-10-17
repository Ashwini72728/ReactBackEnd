package com.java.person.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleDto {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int roleId;
	String roleName;
	
	public RoleDto() {
		
	}

	public RoleDto(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
}

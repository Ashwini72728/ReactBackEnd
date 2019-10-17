package com.java.person.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginDto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int userId;
	String userName;
	String password;
	String email;
	Long mobileNo;
    boolean approved;
    int roleId;
	public LoginDto() {

	}
	
	public LoginDto(int userId, String userName, String password, String email, Long mobileNo, boolean approved,
			int roleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.approved = approved;
		this.roleId = roleId;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "LoginDto [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", approved=" + approved + ", roleId=" + roleId + "]";
	}
	
	
	
}

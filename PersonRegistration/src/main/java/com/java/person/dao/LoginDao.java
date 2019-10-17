package com.java.person.dao;

import java.util.List;
import java.util.Optional;

import com.java.person.dto.LoginDto;

public interface LoginDao {

	public LoginDto matchUserNamePassword(LoginDto login);

	public LoginDto createUserAccount(LoginDto login);

	public int approveUser(LoginDto login);

	public List<LoginDto> getForApproval(boolean istrue);

	public List<LoginDto> search(String name);

	public int changeRole(LoginDto login);

}

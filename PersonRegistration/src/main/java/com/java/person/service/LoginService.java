package com.java.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.person.dto.LoginDto;

@Service
public interface LoginService {

	public LoginDto matchUserNamePassword(LoginDto login);

	public LoginDto createUserAccount(LoginDto login);

	public int approveUser(LoginDto login);

	public List<LoginDto> getForApproval(boolean istrue);

	public List<LoginDto> search(String name);

	public int changeRole(LoginDto login);
	
}

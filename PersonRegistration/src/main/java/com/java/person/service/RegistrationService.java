package com.java.person.service;

import org.springframework.stereotype.Service;

import com.java.person.dto.LoginDto;
import com.java.person.dto.RegistrationDto;

@Service
public interface RegistrationService {

	RegistrationDto saveUserDetails(RegistrationDto reg);

	RegistrationDto addDetails(LoginDto login);

	int changeRole(LoginDto login);

}

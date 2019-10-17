package com.java.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.person.dao.RegistrationDao;
import com.java.person.dto.LoginDto;
import com.java.person.dto.RegistrationDto;
@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationDao registrationDao;
	
	@Override
	public RegistrationDto saveUserDetails(RegistrationDto reg) {
		
		return registrationDao.saveUserDetails(reg);
	}
	@Override
	public RegistrationDto addDetails(LoginDto login) {
		
		return registrationDao.addDetails(login);
	}
	@Override
	public int changeRole(LoginDto login) {
		return registrationDao.changeRole(login);
	}

}

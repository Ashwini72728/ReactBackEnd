package com.java.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.person.dto.LoginDto;
import com.java.person.dto.PersonalInfoCache;
import com.java.person.dto.RegistrationDto;

@Service
public interface PersonalInfoService {
	
	PersonalInfoCache saveUserDetails(RegistrationDto reg);

	PersonalInfoCache addDetails(LoginDto login1);

	int approveUserDetails(PersonalInfoCache details);

	List<PersonalInfoCache> findByRoleId(int id);

	List<PersonalInfoCache> search(String name);

	int changeRole(LoginDto login);

}

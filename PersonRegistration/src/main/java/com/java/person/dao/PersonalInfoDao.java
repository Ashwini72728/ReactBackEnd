package com.java.person.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.person.dto.LoginDto;
import com.java.person.dto.PersonalInfoCache;
import com.java.person.dto.RegistrationDto;

@Repository
public interface PersonalInfoDao {

	PersonalInfoCache saveUserDetails(RegistrationDto reg);

	PersonalInfoCache addDetails(LoginDto login1);

	int approveUserDetails(PersonalInfoCache details);

	List<PersonalInfoCache> findByRoleId(int id);

	List<PersonalInfoCache> search(String name);

	int changeRole(LoginDto login);

}

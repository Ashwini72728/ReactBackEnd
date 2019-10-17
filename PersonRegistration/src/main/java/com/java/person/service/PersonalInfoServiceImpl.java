package com.java.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.person.dao.PersonalInfoDao;
import com.java.person.dto.LoginDto;
import com.java.person.dto.PersonalInfoCache;
import com.java.person.dto.RegistrationDto;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

	@Autowired
	PersonalInfoDao personalInfoDao;

	@Override
	public PersonalInfoCache saveUserDetails(RegistrationDto reg) {

		return personalInfoDao.saveUserDetails(reg);
	}

	@Override
	public PersonalInfoCache addDetails(LoginDto login1) {
		return personalInfoDao.addDetails(login1);
	}

	@Override
	public int approveUserDetails(PersonalInfoCache details) {
		return personalInfoDao.approveUserDetails(details);
	}

	@Override
	public List<PersonalInfoCache> findByRoleId(int id) {
		return personalInfoDao.findByRoleId(id);
	}

	@Override
	public List<PersonalInfoCache> search(String name) {
		return personalInfoDao.search(name);
	}

	@Override
	public int changeRole(LoginDto login) {
		return personalInfoDao.changeRole(login);
	}

}

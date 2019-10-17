package com.java.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.person.dao.RoleDao;
import com.java.person.dto.RoleDto;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public RoleDto createNewRole(RoleDto user) {
		RoleDto r = roleDao.createNewRole(user);
		return r;
	}

	
}

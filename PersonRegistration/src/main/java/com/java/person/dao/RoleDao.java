package com.java.person.dao;


import org.springframework.stereotype.Repository;

import com.java.person.dto.RoleDto;
@Repository
public interface RoleDao{

	public RoleDto createNewRole(RoleDto user);
}

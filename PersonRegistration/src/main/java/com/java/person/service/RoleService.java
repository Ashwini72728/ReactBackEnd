package com.java.person.service;

import org.springframework.stereotype.Service;

import com.java.person.dto.RoleDto;

@Service
public interface RoleService {

	public RoleDto createNewRole(RoleDto user);
}

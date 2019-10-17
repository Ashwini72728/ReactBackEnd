package com.java.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.person.dto.RoleDto;

public interface RoleRepository extends JpaRepository<RoleDto, Integer>{

}

package com.java.person.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.person.dto.LoginDto;

public interface LoginRepository extends JpaRepository<LoginDto, Integer>{

	Optional<LoginDto> findByuserName(String userName);
 
}

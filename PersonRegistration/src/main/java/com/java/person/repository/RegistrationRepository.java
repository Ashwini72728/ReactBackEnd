package com.java.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.person.dto.RegistrationDto;

public interface RegistrationRepository extends JpaRepository<RegistrationDto,Integer>{

}

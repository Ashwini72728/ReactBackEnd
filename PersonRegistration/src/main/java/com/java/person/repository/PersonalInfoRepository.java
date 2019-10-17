package com.java.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.person.dto.PersonalInfoCache;
import com.java.person.dto.RegistrationDto;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfoCache,Integer>{

	PersonalInfoCache save(RegistrationDto reg);

}

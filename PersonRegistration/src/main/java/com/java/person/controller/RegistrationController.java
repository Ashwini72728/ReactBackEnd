package com.java.person.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.person.dto.LoginDto;
import com.java.person.dto.PersonalInfoCache;
import com.java.person.dto.RegistrationDto;
import com.java.person.repository.LoginRepository;
import com.java.person.repository.RegistrationRepository;
import com.java.person.service.PersonalInfoService;
import com.java.person.service.RegistrationService;


@RestController
@CrossOrigin
public class RegistrationController {

	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	PersonalInfoService personalInfoService;
	
	@Autowired
	LoginRepository loginRepository;
	
	@PostMapping(value = "/saveUserDetails")
	public ResponseEntity saveUserDetails(@RequestBody RegistrationDto reg) {
		System.out.println(reg);
		if (reg.isApproved()) {
			RegistrationDto r = registrationService.saveUserDetails(reg);
			if (r == null) {
				return new ResponseEntity("Not Save", HttpStatus.OK);
			}
			return new ResponseEntity(r, HttpStatus.OK);
		} else {
			PersonalInfoCache p = personalInfoService.saveUserDetails(reg);
			if (p == null) {
				return new ResponseEntity("Not Save", HttpStatus.OK);
			}
			return new ResponseEntity(p, HttpStatus.OK);
		}

	}
	
	@GetMapping(value = "/getUserDetail/{id}")
	public ResponseEntity getAllUser(@PathVariable int id){
		Optional<RegistrationDto> list= registrationRepository.findById(id);
		if(!list.isPresent()) {
			Optional<LoginDto> list1 = loginRepository.findById(id);
			return new ResponseEntity(list1, HttpStatus.OK);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
}

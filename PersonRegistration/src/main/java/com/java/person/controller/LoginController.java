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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.person.dto.LoginDto;
import com.java.person.dto.RegistrationDto;
import com.java.person.repository.LoginRepository;
import com.java.person.service.LoginService;
import com.java.person.service.PersonalInfoService;
import com.java.person.service.RegistrationService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	PersonalInfoService personalInfoService;
	
	@Autowired
	LoginRepository loginRepository;
	
	
	@PostMapping(value = "/login")
	public ResponseEntity checkUserNamePassword(@RequestBody LoginDto login) {
		
		LoginDto log = loginService.matchUserNamePassword(login);
		if (log == null || !log.isApproved()) {
			return new ResponseEntity("Not Match", HttpStatus.OK);
		}
		return new ResponseEntity(log, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/signUp")
	public ResponseEntity createUserAccount(@RequestBody LoginDto login) {
		System.out.println("CONTROLLER="+login);
		LoginDto login1 = loginService.createUserAccount(login);
		System.out.println("Login Detail="+login1);
		if(login1.isApproved()) {
			RegistrationDto reg = registrationService.addDetails(login1);
			System.out.println("Registration Details"+reg);
		}
		
		if (login1 == null) {
			return new ResponseEntity("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity(login1, HttpStatus.OK);

	}

	@GetMapping(value = "/getAllUser")
	public ResponseEntity getAllUser(){
			List<LoginDto> list= loginRepository.findAll();
			return new ResponseEntity(list, HttpStatus.OK);
		
	}
	
	@PutMapping(value="/approved")
	public ResponseEntity approveUser(@RequestBody LoginDto login) {
		System.out.println("CONTROLLER="+login);
		int i = loginService.approveUser(login);
		RegistrationDto reg = registrationService.addDetails(login);
		System.out.println("Registration Details"+reg);
		if (i==0) {
			return new ResponseEntity("Not approved", HttpStatus.OK);
		}
		return new ResponseEntity("Success", HttpStatus.OK);

	}
	
	@PostMapping(value="/searchUser/{name}")
	public ResponseEntity searchUserByName(@PathVariable String name) {
		System.out.println("!!!!!!!!!"+name);
		List<LoginDto> list = loginService.search(name);
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/changeRole")
	public ResponseEntity changeRole(@RequestBody LoginDto login) {
		int i = loginService.changeRole(login);
		int j=0;
		if(login.isApproved()) {
			
			j= registrationService.changeRole(login);
		}
		else {
			
			j= personalInfoService.changeRole(login);
		}
		System.out.println(i+")))))))"+j);
		return new ResponseEntity("Success", HttpStatus.OK);			
	}
}

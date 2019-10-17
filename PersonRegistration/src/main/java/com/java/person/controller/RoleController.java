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

import com.java.person.dto.RoleDto;
import com.java.person.repository.RoleRepository;
import com.java.person.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	RoleRepository userRepository;
	
	@PostMapping(value = "/role")
	public ResponseEntity addNewRole(@RequestBody RoleDto user) {
		RoleDto user1 = roleService.createNewRole(user);
		if (user1 == null) {
			return new ResponseEntity("Not Save", HttpStatus.OK);
		}
		return new ResponseEntity(user, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getAllRole")
	public ResponseEntity getAllRole(){
		List<RoleDto> list= userRepository.findAll();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getRole/{id}")
	public ResponseEntity getRoleById(@PathVariable int id){
		Optional<RoleDto> list= userRepository.findById(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
}

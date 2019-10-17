package com.java.person.controller;

import java.util.List;
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

import com.java.person.dto.PersonalInfoCache;
import com.java.person.repository.PersonalInfoRepository;
import com.java.person.service.PersonalInfoService;

@RestController
@CrossOrigin
public class PersonalInfoController {

	@Autowired
	PersonalInfoService personalInfoService;
	
	@Autowired
	PersonalInfoRepository personalInfoRepository;
	
	@PutMapping(value="/approvedDetails")
	public ResponseEntity approveUser(@RequestBody PersonalInfoCache details) {
		System.out.println("CONTROLLER="+details);
		int i = personalInfoService.approveUserDetails(details);
		if (i==0) {
			return new ResponseEntity("Not approved", HttpStatus.OK);
		}
		return new ResponseEntity("Success", HttpStatus.OK);

	}
	
	@GetMapping(value = "/getAllUserDetails/{id}")
	public ResponseEntity getAllUserDetails(@PathVariable int id){
	    List<PersonalInfoCache> list= personalInfoService.findByRoleId(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/searchEditedUser/{name}")
	public ResponseEntity searchUserByName(@PathVariable String name) {
		System.out.println("!!!!!!!!!"+name);
		List<PersonalInfoCache> list = personalInfoService.search(name);
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	
	
	
}

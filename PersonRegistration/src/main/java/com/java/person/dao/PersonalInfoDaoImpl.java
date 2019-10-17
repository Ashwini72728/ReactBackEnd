package com.java.person.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.person.dto.LoginDto;
import com.java.person.dto.PersonalInfoCache;
import com.java.person.dto.RegistrationDto;
import com.java.person.repository.PersonalInfoRepository;
import com.java.person.repository.RegistrationRepository;

@Repository
public class PersonalInfoDaoImpl implements PersonalInfoDao{

	@Autowired 
	PersonalInfoRepository personalInfoRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public PersonalInfoCache saveUserDetails(RegistrationDto reg) {
		System.out.println("|||||||"+reg);
        int userId = reg.getUserId();
        String sql = "select * from personal_info_cache where user_id=?";
        List<PersonalInfoCache> register;
        try {
        	  register = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PersonalInfoCache.class),userId);
			
			  System.out.println(">>>>>>>>>>>>>>>>>>"+register);
			  if(register.size()!=0) {
				  PersonalInfoCache p =new PersonalInfoCache();
				  p.setUserId(register.get(0).getUserId());
				  p.setPersonalId(register.get(0).getPersonalId());
				  p.setRoleId(reg.getRoleId());
				  p.setFirstName(reg.getFirstName());
				  p.setMiddleName(reg.getMiddleName());
				  p.setLastName(reg.getLastName());
				  p.setGender(reg.getGender());
				  p.setDob(reg.getDob());
				  p.setAge(reg.getAge());
				  p.setAddress(reg.getAddress());
				  p.setCity(reg.getCity());
				  p.setPinCode(reg.getPinCode());
				  p.setState(reg.getState());
				  p.setMobileNo(reg.getMobileNo());
				  p.setPhysicalDisability(reg.getPhysicalDisability());
				  p.setMaritalStatus(reg.getMaritalStatus());
				  p.setEducationalStatus(reg.getEducationalStatus());
				  p.setBirthSign(reg.getBirthSign());
				  p.setApproved(register.get(0).isApproved());
				  p.setEmail(reg.getEmail());
				  
			      return personalInfoRepository.save(p);
				 
			  }
			  else {
				  PersonalInfoCache p =new PersonalInfoCache();
				  p.setUserId(reg.getUserId());
				  p.setRoleId(reg.getRoleId());
				  p.setFirstName(reg.getFirstName());
				  p.setMiddleName(reg.getMiddleName());
				  p.setLastName(reg.getLastName());
				  p.setGender(reg.getGender());
				  p.setDob(reg.getDob());
				  p.setAge(reg.getAge());
				  p.setAddress(reg.getAddress());
				  p.setCity(reg.getCity());
				  p.setPinCode(reg.getPinCode());
				  p.setState(reg.getState());
				  p.setMobileNo(reg.getMobileNo());
				  p.setPhysicalDisability(reg.getPhysicalDisability());
				  p.setMaritalStatus(reg.getMaritalStatus());
				  p.setEducationalStatus(reg.getEducationalStatus());
				  p.setBirthSign(reg.getBirthSign());
				  p.setApproved(reg.isApproved());
				  p.setEmail(reg.getEmail());
				  System.out.println("@@@@@@@@@");
				  return personalInfoRepository.save(p);
			  }
			  
			
		}
        catch (EmptyResultDataAccessException e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>");
			return null;
		}	
	}

	@Override
	public PersonalInfoCache addDetails(LoginDto login) {
		PersonalInfoCache p = new PersonalInfoCache();
		p.setUserId(login.getUserId());
		p.setRoleId(login.getRoleId());
		p.setEmail(login.getEmail());
		p.setMobileNo(login.getMobileNo());
		p.setApproved(login.isApproved());
		System.out.println("Register="+p);
		return personalInfoRepository.save(p);
	}

	@Override
	public int approveUserDetails(PersonalInfoCache details) {
		int userId = details.getUserId();
		System.out.println("******"+userId);
		try {

				String sql1 = "select * from personal_info_cache where user_id= ?";
				String sql2 = "select * from person_information where user_id= ?";
				PersonalInfoCache  p = jdbcTemplate.queryForObject(sql1, BeanPropertyRowMapper.newInstance(PersonalInfoCache.class),userId);
				RegistrationDto personalId = jdbcTemplate.queryForObject(sql2, BeanPropertyRowMapper.newInstance(RegistrationDto.class),userId);
				RegistrationDto r = new RegistrationDto();
				r.setPersonalId(personalId.getPersonalId());
				r.setUserId(p.getUserId());
				r.setFirstName(p.getFirstName());
				r.setMiddleName(p.getMiddleName());
				r.setLastName(p.getLastName());
				r.setRoleId(p.getRoleId());
				r.setGender(p.getGender());
				r.setDob(p.getDob());
				r.setAge(p.getAge());
				r.setAddress(p.getAddress());
				r.setCity(p.getCity());
				r.setState(p.getState());
				r.setPinCode(p.getPinCode());
				r.setMobileNo(p.getMobileNo());
				r.setPhysicalDisability(p.getPhysicalDisability());
				r.setMaritalStatus(p.getMaritalStatus());
				r.setEducationalStatus(p.getEducationalStatus());
				r.setBirthSign(p.getBirthSign());
				r.setApproved(true);
				r.setEmail(p.getEmail());
				registrationRepository.save(r);
				System.out.println("******"+p.getPersonalId());
				personalInfoRepository.deleteById(p.getPersonalId());
				return 1;

		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	@Override
	public List<PersonalInfoCache> findByRoleId(int id) {
		
		int roleId = id;
		String sql = "select * from personal_info_cache where role_id=?";
		List<PersonalInfoCache> personal;
		try {
			personal =jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PersonalInfoCache.class),roleId);
			System.out.println("*******"+personal);
			return personal;
		} catch (EmptyResultDataAccessException e) {
			System.out.println(">>>>>>>>>>>>>>>>>>");
			return null;
		}
	}

	@Override
	public List<PersonalInfoCache> search(String name) {
		try {
			String sql = "select * from personal_info_cache where LOWER(first_name) like '"+name+"%' OR first_name like '"+name+"%'";
			List<PersonalInfoCache> loginCredential = jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(PersonalInfoCache.class));
			System.out.println(loginCredential);
			return loginCredential;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int changeRole(LoginDto login) {
		int userId = login.getUserId();
		int roleId = login.getRoleId();
		String sql = "update personal_info_cache set role_id=? where user_id= ?";
		int RoleChangeSuccess;
		try {
			RoleChangeSuccess = jdbcTemplate.update(sql, roleId, userId);
			System.out.println(RoleChangeSuccess);
			if (RoleChangeSuccess > 0) {
				return RoleChangeSuccess;
			}

			return 0;
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

}

package com.java.person.dao;

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
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	PersonalInfoRepository personalInfoRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public RegistrationDto saveUserDetails(RegistrationDto reg) {
		System.out.println("|||||||" + reg);
		int userId = reg.getUserId();
		String sql = "select * from person_information where user_id=?";
		RegistrationDto register;
		try {
			register = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(RegistrationDto.class),
					userId);

			System.out.println(">>>>>>>>>>>>>>>>>>" + register);
			reg.setUserId(register.getUserId());
			reg.setPersonalId(register.getPersonalId());
			reg.setApproved(register.isApproved());
			return registrationRepository.save(reg);
		} catch (EmptyResultDataAccessException e) {
			System.out.println(">>>>>>>>>>>>>>>>>>");
			return null;
		}
	}

	@Override
	public RegistrationDto addDetails(LoginDto login) {
		System.out.println(login);
		RegistrationDto r = new RegistrationDto();
		r.setUserId(login.getUserId());
		r.setRoleId(login.getRoleId());
		r.setEmail(login.getEmail());
		r.setMobileNo(login.getMobileNo());
		r.setApproved(true);
		System.out.println("Register=" + r);
		return registrationRepository.save(r);

	}

	@Override
	public int changeRole(LoginDto login) {
		int userId = login.getUserId();
		int roleId = login.getRoleId();
		String sql = "update person_information set role_id=? where user_id= ?";
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

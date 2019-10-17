package com.java.person.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.person.dto.LoginDto;
import com.java.person.dto.RegistrationDto;
import com.java.person.repository.LoginRepository;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public LoginDto matchUserNamePassword(LoginDto login) {

		String userName = login.getUserName();
		String password = login.getPassword();
		String sql = "select * from login where user_name= ? and password=?";
		try {
			LoginDto loginCredential = jdbcTemplate.queryForObject(sql,
					BeanPropertyRowMapper.newInstance(LoginDto.class), userName, password);

			System.out.println(loginCredential);
			return loginCredential;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public LoginDto createUserAccount(LoginDto login) {
		String userName = login.getUserName();
		String sql = "select * from login where user_name= ?";
		LoginDto loginCredential = null;
		try {
			loginCredential = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(LoginDto.class),
					userName);

			System.out.println(">>>>>>>>>>>>>>>>>>" + loginCredential);
			return null;
		} catch (EmptyResultDataAccessException e) {
			if (loginCredential == null) {
				System.out.println(login.getRoleId());
				if (login.getRoleId() == 0) {
					LoginDto l = jdbcTemplate.queryForObject("select role_id from role where role_name='Access'",
							BeanPropertyRowMapper.newInstance(LoginDto.class));
					login.setRoleId(l.getRoleId());
					return loginRepository.save(login);
				} else {
					return loginRepository.save(login);
				}
			} else {
				return null;
			}
		}
	}

	@Override
	public int approveUser(LoginDto login) {
		int userId = login.getUserId();
		boolean a = true;
		String sql = "update login set approved=? where user_id= ?";
		int approveSuceess;
		try {
			approveSuceess = jdbcTemplate.update(sql, a, userId);
			System.out.println(approveSuceess);
			if (approveSuceess > 0) {
				return approveSuceess;
			}

			return 0;
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	@Override
	public List<LoginDto> getForApproval(boolean istrue) {
		if (istrue) {
			try {
				String sql = "select * from login where approved=?";
				List<LoginDto> loginCredential = jdbcTemplate.query(sql,
						BeanPropertyRowMapper.newInstance(LoginDto.class), istrue);
				return loginCredential;
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		} else {
			try {
				String sql = "select * from login where approved=?";
				List<LoginDto> loginCredential = jdbcTemplate.query(sql,
						BeanPropertyRowMapper.newInstance(LoginDto.class), istrue);
				return loginCredential;
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}


	}

	@Override
	public List<LoginDto> search(String name) {
		try {
			String sql = "select * from login where LOWER(user_name) like '"+name+"%' OR user_name like '"+name+"%'";
			List<LoginDto> loginCredential = jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(LoginDto.class));
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
		String sql = "update login set role_id=? where user_id= ?";
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

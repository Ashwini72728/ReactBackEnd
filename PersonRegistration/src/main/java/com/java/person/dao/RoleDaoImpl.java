package com.java.person.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.person.dto.LoginDto;
import com.java.person.dto.RoleDto;
import com.java.person.repository.RoleRepository;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	RoleRepository userRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public RoleDto createNewRole(RoleDto user) {
		String roleName = user.getRoleName();
		String sql = "select * from role where role_name= ?";
		RoleDto roleDetail = null;
		try {
			roleDetail = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(RoleDto.class), roleName);

			System.out.println(">>>>>>>>>>>>>>>>>>" + roleDetail);
			return null;
		} catch (EmptyResultDataAccessException e) {
			if (roleDetail == null) {

				return userRepository.save(user);
			} else {
				return null;
			}
		}

	};
}

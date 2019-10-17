package com.java.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.person.dao.LoginDao;
import com.java.person.dto.LoginDto;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public LoginDto matchUserNamePassword(LoginDto login) {
		LoginDto l = loginDao.matchUserNamePassword(login);
		return l;
	}

	@Override
	public LoginDto createUserAccount(LoginDto login) {
		LoginDto l = loginDao.createUserAccount(login);
		return l;
	}

	@Override
	public int approveUser(LoginDto login) {
		int l = loginDao.approveUser(login);
		return l;
	}

	@Override
	public List<LoginDto> getForApproval(boolean istrue) {
		return loginDao.getForApproval(istrue);
	}

	@Override
	public List<LoginDto> search(String name) {
		return loginDao.search(name);
	}

	@Override
	public int changeRole(LoginDto login) {
		return loginDao.changeRole(login);
	}


}

package com.mahesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.dao.UserAuthenticationDAO;
import com.mahesh.domain.StudentAppUsers;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	private UserAuthenticationDAO userDao;
	
	public void setUserDao(UserAuthenticationDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public StudentAppUsers loginUser(StudentAppUsers user) {
		return userDao.loginUser(user);
	}

}

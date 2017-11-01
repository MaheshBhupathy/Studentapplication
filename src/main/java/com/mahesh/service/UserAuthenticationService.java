package com.mahesh.service;

import com.mahesh.domain.StudentAppUsers;

public interface UserAuthenticationService {
	
	public boolean checkUser(String username,String password);
	public StudentAppUsers loginUser(StudentAppUsers user);

}

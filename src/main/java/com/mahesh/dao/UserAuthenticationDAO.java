package com.mahesh.dao;

import com.mahesh.domain.StudentAppUsers;

public interface UserAuthenticationDAO {

	public StudentAppUsers loginUser(StudentAppUsers user);
}

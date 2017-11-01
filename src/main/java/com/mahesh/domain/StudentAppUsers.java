package com.mahesh.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentAppUsers implements Serializable {
	
//	 			Name                                      Null?    Type
//			 ----------------------------------------- -------- --------------
//			 USER_ID                                            NUMBER(4)
//			 USERNAME                                           VARCHAR2(20)
//			 PASSWORD                                           VARCHAR2(20)
//			 USER_ROLE                                          VARCHAR2(20)
	
	private Integer userId;
	private String username;
	private String password;
	private String userRole;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}

package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mahesh.domain.StudentAppUsers;
import com.mahesh.queries.SQLConstants;

@Repository
public class UserAuthenticationDAOImpl implements UserAuthenticationDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public StudentAppUsers loginUser(StudentAppUsers user) throws Exception {

		RowMapper<StudentAppUsers> rowMapper = new RowMapper<StudentAppUsers>() {

			@Override
			public StudentAppUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				StudentAppUsers user = new StudentAppUsers();
				user.setUserId(rs.getInt(1));
				user.setUserRole(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(null);
				return user;
			}
		};
		
		return jdbcTemplate.queryForObject(SQLConstants.SQL_STUDENT_APP_USERS_AUTH, rowMapper, user.getUsername(),user.getPassword());
		
		
		
	}

}

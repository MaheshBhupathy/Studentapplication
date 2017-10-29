package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mahesh.domain.StudentsData;
import com.mahesh.queries.SQLConstants;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper<StudentsData> rm = new RowMapper<StudentsData>() {

		@Override
		public StudentsData mapRow(ResultSet rs, int rownum) throws SQLException {
/*
			STUDENT_ID,STUDENT_NAME,STUDENT_MOBILE,STUDENT_CITY*/
			StudentsData students  = new StudentsData();
			students.setStudentId(rs.getInt(1));
			students.setStudentName(rs.getString(2));
			students.setStudentMobile(rs.getLong(3));
			students.setStudentCity(rs.getString(4));
			return students;
		}
		
	};

	@Override
	public List<StudentsData> getStudentDetails() {
		return jdbcTemplate.query(SQLConstants.SQL_STUDENT_APP_GET_ALL_STUDENTS, rm);
		
	}

}

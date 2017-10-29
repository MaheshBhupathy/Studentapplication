package com.mahesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.dao.AdminDAO;
import com.mahesh.domain.StudentsData;


@Service
public class AdminOperationsImpl implements AdminOperations {

	@Autowired
	private AdminDAO adminDao;

	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<StudentsData> getStudents() {

		
		return adminDao.getStudentDetails();
	}

}

package com.mahesh.contrller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mahesh.service.AdminOperations;

@Controller
public class AdminDashBoardController {
	
	@Autowired
	private AdminOperations adminOperations;
	
	public void setAdminOperations(AdminOperations adminOperations) {
		this.adminOperations = adminOperations;
	}

	@RequestMapping(value="getStudents")
	public ModelAndView getStudents() {
		
		return new ModelAndView("AdminDashBoard","students",adminOperations.getStudents());
	}

}

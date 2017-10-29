package com.mahesh.contrller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mahesh.domain.StudentAppUsers;
import com.mahesh.service.UserAuthenticationService;

@Controller
public class UserAuthenticationController {

	private static String loginPage = "index";
	private static String adminPage = "AdminDashBoard";
	private static String studentPage = "StudentDashBoard";
	private static String message = "";
	private static String targetPage;

	@Autowired
	private UserAuthenticationService userService;

	public void setUserService(UserAuthenticationService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "login")
	@PostMapping
	public ModelAndView userLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		StudentAppUsers user = new StudentAppUsers();

		if ((username != null && username.trim().length() > 0) && (password != null && password.trim().length() > 0)) {

			user.setUsername(username);
			user.setPassword(password);
			user = userService.loginUser(user);
			
			if (user != null && user.getUserRole() != null) {
				if (user.getUserRole().equals("admin")) {
					message = "Welcome " +user.getUsername()+ "!";
						targetPage = adminPage;
				} else if (user.getUserRole().equals("student")) {
					message = "Welcome " +user.getUsername()+ "!";
					targetPage = studentPage;
				}
			}

		} else {
			targetPage = loginPage;
			message = "Please provide valid username and password";
		}

		return new ModelAndView(targetPage, "message", message);
	}

}

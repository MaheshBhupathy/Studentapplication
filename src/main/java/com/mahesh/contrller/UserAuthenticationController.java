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

		if (userService.checkUser(username, password)) {
			StudentAppUsers user = new StudentAppUsers();

			user.setUsername(username);
			user.setPassword(password);

			if (userService.loginUser(user).getPassword() != null) {
				targetPage = loginPage;
				message = "Please provide valid username and password";
			} else {
				user = userService.loginUser(user);
				message = "Welcome " + user.getUsername() + "!" + "This is your " + user.getUserRole();
				if (user.getUserRole().equals("admin")) {
					targetPage = adminPage;
				} else if (user.getUserRole().equals("student")) {
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

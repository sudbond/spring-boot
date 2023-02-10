package com.mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypackage.dao.UserDao;
import com.mypackage.model.User1;

//@RestController: It can be considered as a combination of 
//@Controller and @ResponseBody annotations. 
//The @RestController annotation is itself annotated with the @ResponseBody annotation. 
//It eliminates the need for annotating each method with @ResponseBody.
@Controller
public class MyController {

	@Autowired
	UserDao dao;

	@PostMapping("home")
	public String show() {
		return "home.html";
	}

	@GetMapping("login")
	public String login() {
		return "login.html";
	}

	@GetMapping("profile")
	public String profile() {
		return "profile.html";
	}

	@GetMapping("logoutsucccess")
	@ResponseBody
	public String logout() {
		return "You have logged out successfully";
	}

	@PostMapping("failure")
	@ResponseBody
	public String failure() {
		return "Invalid Password or Username";
	}

	@GetMapping("register")
	public String register() {
		return "register.html";
	}

	@PostMapping("register")
	@ResponseBody
	public String doregister(User1 user) {
		dao.save(new User1(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), "ROLE_USER"));
		return "registered successfully";
	}

	@GetMapping("admin/home")
	public String adminPage() {
		return "adminhome.html";
	}
}

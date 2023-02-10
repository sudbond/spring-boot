package com.mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mypackage.model.User;

@Controller
public class MyController {
	@Autowired
	User u;

	@RequestMapping("/log")
	public String show() {
		return "log";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {
		u.setUsername(username);
		u.setPassword(password);

		if (u.getUsername().equals("admin") && u.getPassword().equals("admin")) {
			return "success";
		}
		// return "failure";
		m.addAttribute("msg", "incorrect username or password");
		return "log";
	}
}

package com.mypackage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypackage.model.User;

@Controller
public class MyController {
	@RequestMapping("/signup")
	public String show() {
		return "SignUp";
	}
	@RequestMapping("/register")
public String signUp(User u,Model m) {
		m.addAttribute("msg", u);
	return "success";
}
}


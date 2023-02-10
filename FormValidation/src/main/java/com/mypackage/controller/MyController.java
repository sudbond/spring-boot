package com.mypackage.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypackage.Service.User;

@Controller
public class MyController {

	@RequestMapping("/")
	public String getForm(User user) {
		return "form.html";
	}

	@RequestMapping("user")
	public String setData(@Valid User user, BindingResult bind) {
		if (bind.hasErrors()) {
			return "form.html";
		} else {
			return "success.html";
		}
	}

}

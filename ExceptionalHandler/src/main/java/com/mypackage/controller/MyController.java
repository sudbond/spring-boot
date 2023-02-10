package com.mypackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public String first() {
		return "index.html";
	}

	@RequestMapping("/divide")
	@ResponseBody
	public int divide(@RequestParam("a") int a, @RequestParam("b") int b) {
		int c = a / b;
		return c;

	}

	@ExceptionHandler({ ArithmeticException.class })
	public String handler() {
		return "error.html";
	}
}

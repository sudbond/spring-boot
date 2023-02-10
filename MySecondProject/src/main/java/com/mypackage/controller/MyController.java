package com.mypackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	// ------------------------------Addition
	// Code------------------------------------------
	@RequestMapping("/add")
	public String show() {
		return "addition.html";
	}

	@RequestMapping("/addition")
	public String addition(@RequestParam("num1") int x, @RequestParam("num2") int y, Model m) {
		int z = x + y;
		m.addAttribute("answer", z);
		return "addition.html";
	}

	// ----------------------------Subtraction
	// Code-------------------------------------------
	@RequestMapping("/sub")
	public String show1() {
		return "subtraction.html";
	}

	@RequestMapping("/subtraction")
	public String Subtraction(@RequestParam("num1") int x, @RequestParam("num2") int y, Model m) {
		int z = x - y;
		m.addAttribute("answer", z);
		return "subtraction.html";
	}

	// ------------------------------Multiplication---------------------------------------
	@RequestMapping("/mul")
	public String show2() {
		return "multiplication.html";
	}

	@RequestMapping("/multiplication")
	public String multiplication(@RequestParam("num1") int x, @RequestParam("num2") int y, Model m) {
		int z = x * y;
		m.addAttribute("result", z);
		return "multiplication.html";
	}
	//-------------------------------Division-------------------------------------------
	@RequestMapping("/div")
	public String show3() {
		return "division.html";
	}
	@RequestMapping("/divide")
	public String division(@RequestParam("num1")int x,@RequestParam("num2")int y,Model m) {
		int z = x/y;
		m.addAttribute("res", z);
		return "division.html";
	}
}
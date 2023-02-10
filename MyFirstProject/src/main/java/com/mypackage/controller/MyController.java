package com.mypackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	// ------------------Addition-------------------------------------------------
	// to show add
	@RequestMapping("/")
	public String show() {
		return "Add.html";

	}

	@RequestMapping("/add")
	@ResponseBody
	// method to add numbers

	public int add(@RequestParam("num1") int x, @RequestParam("num2") int y) {
		int z = x + y;
		return z;
	}

	// --------------------Subtraction---------------------------------------------
	// to show subtraction
	@RequestMapping("/sub")
	public String show1() {
		return "subtract.html";
	}

	@RequestMapping("/subtract")
	@ResponseBody
	// method to subtract
	public int substract(@RequestParam("num1") int x, @RequestParam("num2") int y) {
		int z = x - y;
		return z;
	}

	// --------------------------------------Division----------------------------------
	// method to show division
	@RequestMapping("/div")
	public String show2() {
		return "div.html";
	}

	// method to divide two numbers
	@RequestMapping("/division")
	@ResponseBody
	public int division(@RequestParam("num1") int x, @RequestParam("num2") int y) {
		int z = x / y;
		return z;
	}

	// -----------------------------Multiplication--------------------------------------
	@RequestMapping("/mul")
	public String show3() {
		return "mul.html";
	}

	@RequestMapping("/multipliction")
	@ResponseBody
	public int multiplication(@RequestParam("num1") int x, @RequestParam("num2") int y) {
		int z = x * y;
		return z;
	}
}
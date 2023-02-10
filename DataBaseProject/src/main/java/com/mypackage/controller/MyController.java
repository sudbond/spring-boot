package com.mypackage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypackage.dao.UserDao;
import com.mypackage.model.MyUser;

//@Controller: The @Controller is a class-level annotation. 
//It is a specialization of @Component. 
//It marks a class as a web request handler. 
//It is used to serve web pages. 
//By default, it returns a string that indicates which route to redirect. 
@Controller
public class MyController {
	// It is used to autowire spring bean on setter methods,
	// instance variable, and constructor.
	// When we use @Autowired annotation,
	// the spring container auto-wires the bean by matching data-type.

	@Autowired
	UserDao dao;

	// ---------------------------------------------------------------------------
	// ----------------------method to register a user----------------------------
	// ---------------------------------------------------------------------------
	@RequestMapping("/signup")
	public String getForm() {
		return "register";
	}

	// Annotation for mapping web requests onto method
	@RequestMapping("/register")
	@ResponseBody
	public String register(MyUser u) {
		dao.save(u);
		return "You have successfully signed Up";
	}

	// ---------------------------------------------------------------------------
	// ----------------------method to search a user------------------------------
	// ---------------------------------------------------------------------------
	@RequestMapping("/search/{username}")
	// @ResponseBody: It binds the method return value to the response body.
	// It tells the Spring Boot Framework to serialize
	// a return an object into JSON and XML format.
	@ResponseBody
	public String search(@PathVariable("username") String username) {
		Optional<MyUser> op = dao.findById(username);
		if (op.isPresent()) {
			return "record found";
		} else {
			return "record does not found";
		}
	}

	// ---------------------------------------------------------------------------
	// --------------------- method to delete a user------------------------------
	// ---------------------------------------------------------------------------
	@RequestMapping("/delete/{username}")
	@ResponseBody
	public String delete(@PathVariable("username") String username) {
		Optional<MyUser> op = dao.findById(username);
		if (op.isPresent()) {
			dao.deleteById(username);
			return "record deleted successfully";
		} else {
			return "record does not found";
		}
	}

	// ----------------------------------------------------------------------------
	// ----------------- method to update a record---------------------------------
	// ----------------------------------------------------------------------------
	@RequestMapping("/update")
	public String update1() {
		return "search.html";
	}

	@RequestMapping("/update1")
	public String Update(@RequestParam("username") String username, Model m) {
		Optional<MyUser> op = dao.findById(username);
		System.out.println(username);
		System.out.println(op);
		if (op.isPresent()) {
			m.addAttribute("user", op.get());
			return "update.html";
		} else {
			return "error.html";
		}
	}

	@ResponseBody
	@RequestMapping("/updaterecord")
	public String updateRecord(MyUser u) {
		dao.save(u);
		return "Record Updated Successfully";
	}

	// ----------------------------------------------------------------------------
	// ----------------- method to show all records--------------------------------
	// ----------------------------------------------------------------------------
	@RequestMapping("/showall")
	public String showAll(Model m) {
		List<MyUser> list = dao.findAll();
		m.addAttribute("users", list);
		return "showall.html";
	}
}

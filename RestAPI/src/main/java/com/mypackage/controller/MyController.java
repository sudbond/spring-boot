package com.mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypackage.dao.UserDao;
import com.mypackage.model.Student;

//@RestController: It can be considered as a combination of 
//@Controller and @ResponseBody annotations. 
//The @RestController annotation is itself annotated with the 
//@ResponseBody annotation. 
//It eliminates the need for annotating each method with @ResponseBody.
@RestController
public class MyController {
	// The @Autowired annotation marks a Constructor,
	// Setter method, Properties and Config() method
	// as to be autowired that is ‘injecting beans'(Objects) at runtime
	// by Spring Dependency Injection mechanism
	@Autowired
	UserDao dao;

	// ---------------------------------------------------------------------------
	// ----------------------method to add a record----------------------------
	// ---------------------------------------------------------------------------
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student s) {
		int roll = s.getRoll();
		Student st = dao.findById(roll).orElse(null);
		if (st == null) {
			dao.save(s);
			return new ResponseEntity<String>("Record added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Record already exists", HttpStatus.CONFLICT);
		}
	}

	// ---------------------------------------------------------------------------
	// ----------------------method to update a record----------------------------
	// ---------------------------------------------------------------------------
	@PutMapping("update")
	public ResponseEntity<String> updateStudent(@RequestBody Student s) {
		int roll = s.getRoll();
		Student st = dao.findById(roll).orElse(null);
		if (st != null) {
			dao.save(s);
			return new ResponseEntity<String>("Record Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Record does not exist", HttpStatus.NOT_FOUND);
		}
	}
	// ---------------------------------------------------------------------------
	// ----------------------method to get a record-------------------------------
	// ---------------------------------------------------------------------------

	// @GetMapping: It maps the HTTP GET requests on the
	// specific handler method.
	// It is used to create a web service endpoint that fetches
	// It is used instead of using: @RequestMapping(method = RequestMethod.GET)
	@GetMapping("/{roll}")
	public Student getStudent(@PathVariable("roll") int roll) {
		Student s = dao.findById(roll).orElse(null);
		return s;
	}

	// ---------------------------------------------------------------------------
	// ----------------------method to delete a record----------------------------
	// ---------------------------------------------------------------------------

	// @DeleteMapping: It maps the HTTP DELETE requests
	// on the specific handler method.
	// It is used to create a web service endpoint that deletes a resource.
	// It is used instead of using: @RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping("/{roll}")
	// @PathVariable: It is used to extract the values from the URI.
	// It is most suitable for the RESTful web service,
	// where the URL contains a path variable.
	// We can define multiple @PathVariable in a method.
	public ResponseEntity<String> deleteStudent(@PathVariable("roll") int roll) {
		Student s = dao.findById(roll).orElse(null);
		if (s != null) {
			dao.deleteById(roll);
			return new ResponseEntity<String>("record deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Record is not available", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getall")
	public List<Student> getAll(){
		return dao.findAll();
	}
}

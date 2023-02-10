//to define the roll of admin

package com.mypackage.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mypackage.dao.UserDao;
import com.mypackage.model.User1;

@Component
public class RoleService {
	@Autowired
	UserDao dao;

	@PostConstruct
	public void init() {
		User1 u = new User1();
		u.setUsername("admin");
		String password = new BCryptPasswordEncoder().encode("admin");
		u.setPassword(password);
		u.setRole("ROLE_ADMIN");
		dao.save(u);
		System.out.println("Record saved successfully");
	}
}

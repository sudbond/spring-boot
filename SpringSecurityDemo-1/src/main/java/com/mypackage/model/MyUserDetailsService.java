package com.mypackage.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypackage.dao.UserDao;

@Service
public class MyUserDetailsService implements UserDetailsService {
	// @AutoWired:When we use @Autowired annotation,
	// the spring container auto-wires the bean by matching data-type.
	@Autowired
	UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User1> user = dao.findById(username);
		if (user.isPresent()) {
			return user.map(MyUserDetails::new).get();
		} else {
			return null;
		}
	}
}

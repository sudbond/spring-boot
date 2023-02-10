//The UserDetailsService interface is used to retrieve user-related data. 
//It has one method named loadUserByUsername() 
//which can be overridden to customize the process of finding the user.

//It is used by the DaoAuthenticationProvider to load details about the user during authentication.

//In order to provide our own user service, 
//we will need to implement the UserDetailsService interface.

//We'll create a class called MyUserDetailsService 
//that overrides the method loadUserByUsername() of the interface.

//In this method, we retrieve the User object using the DAO, and if it exists, 
//map it into a MyUserDetails object, 
//which implements UserDetails, and returns it:

package com.mypackage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypackage.dao.UserDao;
import com.mypackage.model.User1;

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

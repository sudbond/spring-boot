package com.mypackage.webSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mypackage.model.MyUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
//@Configuration: It is a class-level annotation. 
//The class annotated with @Configuration used by Spring Containers 
//as a source of bean definitions.
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetailsService userservice;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().userDetailsService(userservice).formLogin();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passwordEncoder());
		dao.setUserDetailsService(userservice);
		return dao;
	}

	// @Bean: It is a method-level annotation.
	// It is an alternative of XML <bean> tag.
	// It tells the method to produce a bean to be managed by Spring Container.
	@Bean
	PasswordEncoder passwordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
	}

}

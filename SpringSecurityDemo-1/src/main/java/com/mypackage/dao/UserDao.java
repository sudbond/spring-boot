package com.mypackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.model.User1;

public interface UserDao extends JpaRepository<User1, String> {

}

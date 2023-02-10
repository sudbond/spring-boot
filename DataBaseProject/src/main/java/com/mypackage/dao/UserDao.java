package com.mypackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.model.MyUser;


public interface UserDao extends JpaRepository<MyUser, String> {

}

package com.mypackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.model.Student;



public interface UserDao extends JpaRepository<Student, Integer> {

}

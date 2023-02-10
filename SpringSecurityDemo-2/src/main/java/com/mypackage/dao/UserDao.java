//For the purpose of retrieving a user associated with a username, 
//we will create a DAO class using Spring Data by 
//extending the JpaRepository interface:

package com.mypackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.model.User1;

public interface UserDao extends JpaRepository<User1, String> {

}

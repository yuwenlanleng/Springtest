package com.zhk.test.pringDIorIOC.dao.impl;

import com.zhk.test.pringDIorIOC.dao.UserDAO;
import com.zhk.test.pringDIorIOC.model.User;

public class UserDAOImpl implements UserDAO {

	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("user saved!");
	}

}

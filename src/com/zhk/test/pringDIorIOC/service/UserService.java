package com.zhk.test.pringDIorIOC.service;
import com.zhk.test.pringDIorIOC.dao.UserDAO;
import com.zhk.test.pringDIorIOC.model.User;



public class UserService {
	private UserDAO userDAO;  
	public void add(User user) {
		userDAO.save(user);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}

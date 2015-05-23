package com.zdz.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdz.dao.UserDAO;
import com.zdz.dao.impl.UserDAOImpl;
import com.zdz.model.User;

public class UserService {

	private UserDAO userDAO;

	public void add(User user)
	{
		userDAO.save(user);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name = "u")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	


}

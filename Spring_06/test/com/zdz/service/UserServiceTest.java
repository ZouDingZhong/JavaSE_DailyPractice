package com.zdz.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zdz.model.User;

public class UserServiceTest {
	@Test
	public void testUserService()
	{
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService)ac.getBean("userService");
		User user = new User();
		user.setPassWord("23333");
		user.setUserName("hibernate");
		us.add(user);
		
	}
	
}

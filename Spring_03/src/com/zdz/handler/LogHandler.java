package com.zdz.handler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogHandler{
	
	@Before("execution(public * com.zdz.dao.impl.UserDAOImpl.save(com.zdz.model.User))")
	public void befor()
	{
		System.out.println("begin ...");
	}
	@After("execution(public * com.zdz.service..*.add(..))")
	public void after()
	{
		System.out.println("the end ...");
	}
}
package com.zdz.handler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

public class LogHandler{
	
	public void before()
	{
		System.out.println("begin ...");
	}
	
	public void after()
	{
		System.out.println("the end ...");
	}
}
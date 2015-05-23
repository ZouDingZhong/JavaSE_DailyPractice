package com.zdz.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.zdz.dao.UserDAO;
import com.zdz.model.User;
@Component
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory = null;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}

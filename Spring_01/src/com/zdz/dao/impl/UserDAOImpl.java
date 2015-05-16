package com.zdz.dao.impl;

import com.zdz.dao.UserDAO;
import com.zdz.model.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public void save(User user) {
		System.out.print("User saved");
	}

}

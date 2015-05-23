package com.zdz.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import org.springframework.stereotype.Component;

import com.zdz.dao.UserDAO;
import com.zdz.model.User;
import com.zdz.service.UserService;
@Component
public class UserDAOImpl implements UserDAO{

	private DataSource dataSource = null;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(User user) {
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String sql = "insert into user values ("+user.getId()+",'"+user.getUserName()+"','"+user.getPassWord()+"')";
//			System.out.println(sql);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

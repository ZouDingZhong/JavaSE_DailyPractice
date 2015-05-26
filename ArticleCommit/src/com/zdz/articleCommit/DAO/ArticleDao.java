package com.zdz.articleCommit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zdz.articleCommit.model.Article;

public class ArticleDao {
	private Connection connection;
	public ArticleDao()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			String URL = "jdbc:mysql://127.0.0.1:3306/spring";
			connection= DriverManager.getConnection(URL,"root","root");
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	public void save(Article article)
	{
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into article values (null,?,?,?,?)");
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setDate(3, article.getDate());
			ps.setInt(4, article.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}

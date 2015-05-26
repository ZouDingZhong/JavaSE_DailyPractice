package com.zdz.articleCommit.action;


import java.sql.Date;

import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.zdz.articleCommit.Dao.ArticleDao;
import com.zdz.articleCommit.Dao.impl.ArticleDaoImpl;
import com.zdz.articleCommit.model.Article;
import com.zdz.articleCommit.service.ArticleService;

public class CommitAction extends ActionSupport{
	
	private String title;
	private Date date;
	private String contend;
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContend() {
		return contend;
	}

	public void setContend(String contend) {
		this.contend = contend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public String execute()
	{
		Article article = new Article();
		article.setContent(contend);
		article.setTitle(title);
		article.setDate(new Date(System.currentTimeMillis()));
		article.setUserId(userId);
		ArticleDao articleDao = new ArticleDaoImpl();
		ArticleService articleService = new ArticleService();
		articleService.setArticleDao(articleDao);
		
		articleService.save(article);
		
		System.out.println("this is come from struts2!");
		return SUCCESS;
	}
}

package com.zdz.articleCommit.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zdz.articleCommit.Dao.ArticleDao;
import com.zdz.articleCommit.model.Article;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void save(Article article)
	{
		articleDao.save(article);
	}
}

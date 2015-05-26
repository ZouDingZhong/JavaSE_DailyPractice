package com.zdz.articleCommit.Dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.zdz.articleCommit.Dao.ArticleDao;
import com.zdz.articleCommit.model.Article;

public class ArticleDaoImpl implements ArticleDao{

	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void save(Article article) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();
		session.close();
	}

}

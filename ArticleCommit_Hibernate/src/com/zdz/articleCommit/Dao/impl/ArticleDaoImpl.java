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
	public ArticleDaoImpl()
	{
		Configuration cfg = new Configuration();   
        cfg.configure();//读取配置文件    
          
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
		sessionFactory = cfg.buildSessionFactory(serviceRegistry); 
	}
	@Override
	public void save(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();
	}

}

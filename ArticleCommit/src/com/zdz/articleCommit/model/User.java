package com.zdz.articleCommit.model;

import java.util.LinkedList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private List<Article> articles = new LinkedList<Article>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}

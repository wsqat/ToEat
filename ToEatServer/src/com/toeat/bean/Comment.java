package com.toeat.bean;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Article article;
	private String content;
	private Timestamp editTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Article article) {
		this.article = article;
	}

	/** full constructor */
	public Comment(User user, Article article, String content,
			Timestamp editTime) {
		this.user = user;
		this.article = article;
		this.content = content;
		this.editTime = editTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

}
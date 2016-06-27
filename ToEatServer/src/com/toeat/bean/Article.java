package com.toeat.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient User user;
	private transient Articlecategory articlecategory;
	private String title;
	private String content;
	private Timestamp editTime;
	private transient Set comments = new HashSet(0);

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(User user, Articlecategory articlecategory) {
		this.user = user;
		this.articlecategory = articlecategory;
	}

	/** full constructor */
	public Article(User user, Articlecategory articlecategory, String title,
			String content, Timestamp editTime, Set comments) {
		this.user = user;
		this.articlecategory = articlecategory;
		this.title = title;
		this.content = content;
		this.editTime = editTime;
		this.comments = comments;
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

	public Articlecategory getArticlecategory() {
		return this.articlecategory;
	}

	public void setArticlecategory(Articlecategory articlecategory) {
		this.articlecategory = articlecategory;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}
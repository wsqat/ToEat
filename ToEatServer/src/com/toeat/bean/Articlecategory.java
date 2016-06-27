package com.toeat.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Articlecategory entity. @author MyEclipse Persistence Tools
 */

public class Articlecategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer parentid;
	private String remark;
	private Set articles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Articlecategory() {
	}

	/** full constructor */
	public Articlecategory(String name, Integer parentid, String remark,
			Set articles) {
		this.name = name;
		this.parentid = parentid;
		this.remark = remark;
		this.articles = articles;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getArticles() {
		return this.articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

}
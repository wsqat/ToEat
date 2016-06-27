package com.toeat.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Videocategory entity. @author MyEclipse Persistence Tools
 */

public class Videocategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer parentid;
	private String remark;
	private Set videos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Videocategory() {
	}

	/** full constructor */
	public Videocategory(String name, Integer parentid, String remark,
			Set videos) {
		this.name = name;
		this.parentid = parentid;
		this.remark = remark;
		this.videos = videos;
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

	public Set getVideos() {
		return this.videos;
	}

	public void setVideos(Set videos) {
		this.videos = videos;
	}

}
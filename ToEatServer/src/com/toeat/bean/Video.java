package com.toeat.bean;

import java.sql.Timestamp;

/**
 * Video entity. @author MyEclipse Persistence Tools
 */

public class Video implements java.io.Serializable {

	// Fields

	private Integer id;
	private transient User user;
	private transient Videocategory videocategory;
	private transient Videostate videostate;
	private String name;
	private String intro;
	private Timestamp editTime;
	private String thumbnailurl;
	private String url;
	private String remark;
	private Integer islive;
	private Integer ponits;
	private String oriurl;

	// Constructors

	/** default constructor */
	public Video() {
	}

	/** minimal constructor */
	public Video(User user, Videocategory videocategory, Videostate videostate) {
		this.user = user;
		this.videocategory = videocategory;
		this.videostate = videostate;
	}

	/** full constructor */
	public Video(User user, Videocategory videocategory, Videostate videostate,
			String name, String intro, Timestamp editTime, String thumbnailurl,
			String url, String remark, Integer islive, Integer ponits,
			String oriurl) {
		this.user = user;
		this.videocategory = videocategory;
		this.videostate = videostate;
		this.name = name;
		this.intro = intro;
		this.editTime = editTime;
		this.thumbnailurl = thumbnailurl;
		this.url = url;
		this.remark = remark;
		this.islive = islive;
		this.ponits = ponits;
		this.oriurl = oriurl;
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

	public Videocategory getVideocategory() {
		return this.videocategory;
	}

	public void setVideocategory(Videocategory videocategory) {
		this.videocategory = videocategory;
	}

	public Videostate getVideostate() {
		return this.videostate;
	}

	public void setVideostate(Videostate videostate) {
		this.videostate = videostate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

	public String getThumbnailurl() {
		return this.thumbnailurl;
	}

	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIslive() {
		return this.islive;
	}

	public void setIslive(Integer islive) {
		this.islive = islive;
	}

	public Integer getPonits() {
		return this.ponits;
	}

	public void setPonits(Integer ponits) {
		this.ponits = ponits;
	}

	public String getOriurl() {
		return this.oriurl;
	}

	public void setOriurl(String oriurl) {
		this.oriurl = oriurl;
	}

}
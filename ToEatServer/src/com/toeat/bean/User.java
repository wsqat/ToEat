package com.toeat.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String email;
     private String phone;
     private String password;
     private Timestamp regTime;
     private Set videos = new HashSet(0);
     private Set comments = new HashSet(0);
     private Set goods = new HashSet(0);
     private Set articles = new HashSet(0);
 	public static String PHONE = "phone";
	public static String PASSWORD = "password";
	public static String USERNAME = "name";

    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String name, String email, String phone, String password, Timestamp regTime, Set videos, Set comments, Set goods, Set articles) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.regTime = regTime;
        this.videos = videos;
        this.comments = comments;
        this.goods = goods;
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

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegTime() {
        return this.regTime;
    }
    
    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public Set getVideos() {
        return this.videos;
    }
    
    public void setVideos(Set videos) {
        this.videos = videos;
    }

    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }

    public Set getGoods() {
        return this.goods;
    }
    
    public void setGoods(Set goods) {
        this.goods = goods;
    }

    public Set getArticles() {
        return this.articles;
    }
    
    public void setArticles(Set articles) {
        this.articles = articles;
    }
   








}
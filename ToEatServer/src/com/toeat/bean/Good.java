package com.toeat.bean;

import java.sql.Timestamp;


/**
 * Good entity. @author MyEclipse Persistence Tools
 */

public class Good  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private transient User user;
     private transient Goodsubcategory goodsubcategory;
     private String name;
     private String intro;
     private Timestamp editTime;
     private Double sprice;
     private String productPhoto;


    // Constructors

    /** default constructor */
    public Good() {
    }

	/** minimal constructor */
    public Good(User user, Goodsubcategory goodsubcategory, Double sprice) {
        this.user = user;
        this.goodsubcategory = goodsubcategory;
        this.sprice = sprice;
    }
    
    /** full constructor */
    public Good(User user, Goodsubcategory goodsubcategory, String name, String intro, Timestamp editTime, Double sprice, String productPhoto) {
        this.user = user;
        this.goodsubcategory = goodsubcategory;
        this.name = name;
        this.intro = intro;
        this.editTime = editTime;
        this.sprice = sprice;
        this.productPhoto = productPhoto;
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

    public Goodsubcategory getGoodsubcategory() {
        return this.goodsubcategory;
    }
    
    public void setGoodsubcategory(Goodsubcategory goodsubcategory) {
        this.goodsubcategory = goodsubcategory;
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

    public Double getSprice() {
        return this.sprice;
    }
    
    public void setSprice(Double sprice) {
        this.sprice = sprice;
    }

    public String getProductPhoto() {
        return this.productPhoto;
    }
    
    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }
   








}
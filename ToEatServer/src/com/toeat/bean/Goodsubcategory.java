package com.toeat.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * Goodsubcategory entity. @author MyEclipse Persistence Tools
 */

public class Goodsubcategory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private transient Goodcategory goodcategory;
     private String name;
     private String image;
     private String remark;
     private Set goods = new HashSet(0);


    // Constructors

    /** default constructor */
    public Goodsubcategory() {
    }

	/** minimal constructor */
    public Goodsubcategory(Goodcategory goodcategory, String image) {
        this.goodcategory = goodcategory;
        this.image = image;
    }
    
    /** full constructor */
    public Goodsubcategory(Goodcategory goodcategory, String name, String image, String remark, Set goods) {
        this.goodcategory = goodcategory;
        this.name = name;
        this.image = image;
        this.remark = remark;
        this.goods = goods;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Goodcategory getGoodcategory() {
        return this.goodcategory;
    }
    
    public void setGoodcategory(Goodcategory goodcategory) {
        this.goodcategory = goodcategory;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set getGoods() {
        return this.goods;
    }
    
    public void setGoods(Set goods) {
        this.goods = goods;
    }
   








}
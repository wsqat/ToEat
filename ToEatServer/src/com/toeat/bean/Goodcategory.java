package com.toeat.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * Goodcategory entity. @author MyEclipse Persistence Tools
 */

public class Goodcategory  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer parentid;
     private String remark;
     private Set goodsubcategories = new HashSet(0);


    // Constructors

    /** default constructor */
    public Goodcategory() {
    }

    
    /** full constructor */
    public Goodcategory(String name, Integer parentid, String remark, Set goodsubcategories) {
        this.name = name;
        this.parentid = parentid;
        this.remark = remark;
        this.goodsubcategories = goodsubcategories;
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

    public Set getGoodsubcategories() {
        return this.goodsubcategories;
    }
    
    public void setGoodsubcategories(Set goodsubcategories) {
        this.goodsubcategories = goodsubcategories;
    }
   








}
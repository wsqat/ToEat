package com.toeat.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/6/4.
 */
public class Good implements Serializable {
    // Fields
    private Integer id;
    private String name;
    private String intro;
    private String editTime;
    private Double sprice;
    private String productPhoto;

    public Good(Integer id, String name, String intro, Double sprice, String productPhoto) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.sprice = sprice;
        this.productPhoto = productPhoto;
    }

    public Good(Integer id, String name, String intro, String editTime, Double sprice, String productPhoto) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.editTime = editTime;
        this.sprice = sprice;
        this.productPhoto = productPhoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public Double getSprice() {
        return sprice;
    }

    public void setSprice(Double sprice) {
        this.sprice = sprice;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }
}

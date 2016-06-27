package com.toeat.entities;

import java.util.List;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/6/4.
 */
public class Category implements java.io.Serializable {
    private Integer id;
    private String name;
    private Integer parentid;
    private String remark;
    private List<Good> goodList;

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }

    public Category(Integer id, String name, Integer parentid, String remark) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
        this.remark = remark;
    }

    public Category(Integer id, String name,List<Good> goodList) {
        this.goodList = goodList;
        this.id = id;
        this.name = name;
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

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

package com.toeat.entities;

import java.util.List;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/6/4.
 */
public class TopCategory {
    private int product_category_no;
    private String product_category_name;

    public TopCategory(int product_category_no, String product_category_name) {
        this.product_category_no = product_category_no;
        this.product_category_name = product_category_name;
    }

    public int getProduct_category_no() {
        return product_category_no;
    }

    public void setProduct_category_no(int product_category_no) {
        this.product_category_no = product_category_no;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }
}

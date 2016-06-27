package com.toeat.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/6/10
 */
public class MyLinearLayout extends LinearLayout {
    private int product_subcategory_no;
    private String product_subcategory_name;
    private String product_subcategory_img_url;

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getProduct_subcategory_no() {
        return product_subcategory_no;
    }

    public void setProduct_subcategory_no(int product_subcategory_no) {
        this.product_subcategory_no = product_subcategory_no;
    }

    public String getProduct_subcategory_name() {
        return product_subcategory_name;
    }

    public void setProduct_subcategory_name(String product_subcategory_name) {
        this.product_subcategory_name = product_subcategory_name;
    }

    public String getProduct_subcategory_img_url() {
        return product_subcategory_img_url;
    }

    public void setProduct_subcategory_img_url(String product_subcategory_img_url) {
        this.product_subcategory_img_url = product_subcategory_img_url;
    }
}

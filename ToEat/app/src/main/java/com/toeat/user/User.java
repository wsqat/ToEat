package com.toeat.user;

import java.io.Serializable;
import java.util.Date;
/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/5/10.
 */
public class User implements Serializable {
    private int id;
    private String phone;
    private String password;
    private String name;
    private String email;
    private Date regTime;
    public static String PHONE = "phone";
    public static String PASSWORD = "password";
    public static String USERNAME = "name";

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public User(String phone, String password, String name) {
        this.phone = phone;
        this.password = password;

        this.name = name;
        regTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

package com.xzy.model;

import java.util.Date;

public class User {
    private long user_ID;
    private String email;
    private String phone;
    private String user_pwd;


    private String user_name;
    private Date DATE;
    private String user_pic;
    private String user_real_name;
    private Date user_birth;
    private char user_sex;

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }

    public String getUser_real_name() {
        return user_real_name;
    }

    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public char getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(char user_sex) {
        this.user_sex = user_sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_ID=" + user_ID +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_name='" + user_name + '\'' +
                ", DATE=" + DATE +
                ", user_pic='" + user_pic + '\'' +
                ", user_real_name='" + user_real_name + '\'' +
                ", user_birth=" + user_birth +
                ", user_sex=" + user_sex +
                '}';
    }
}
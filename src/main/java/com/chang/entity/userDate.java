package com.chang.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class userDate {
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private int age;
    private String sex;
    private String address;
    private String identity;
    private String avatar;
    public Timestamp date;
    public Timestamp seal;

    public userDate() {
    }
    public userDate(String user_id, String user_name, String user_email, String user_password, int age, String sex, String address, String identity, String avatar, Timestamp date, Timestamp seal) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.identity = identity;
        this.avatar = avatar;
        this.date = date;
        this.seal = seal;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getSeal() {
        return seal;
    }

    public void setSeal(Timestamp seal) {
        this.seal = seal;
    }

    @Override
    public String toString() {
        return "userDate{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", identity='" + identity + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date=" + date +
                ", seal=" + seal +
                '}';
    }
}

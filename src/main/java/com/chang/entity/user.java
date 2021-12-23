package com.chang.entity;


public class user {
    private String user_id;
    private String user_name;
    private String user_email;
    private String avatar;
    public user() {
    }

    public user(String user_id, String user_name, String user_email, String avatar) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}



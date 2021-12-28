package com.chang.entity;

import java.sql.Date;

public class articleDate extends createVCode {
    private String article_name;
    private String article_id;
    private String article_label;
    private String user_id;
    private int like_num;
    private int click_num;
    private int Audit;
    private String article;
    public Date date;

    public articleDate() {
    }

    public articleDate(String article_name, String article_id, String article_label, String user_id, int like, int click, int audit, String article, Date date) {
        this.article_name = article_name;
        this.article_id = article_id;
        this.article_label = article_label;
        this.user_id = user_id;
        this.like_num = like;
        this.click_num = click;
        Audit = audit;
        this.article = article;
        this.date = date;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_label() {
        return article_label;
    }

    public void setArticle_label(String article_label) {
        this.article_label = article_label;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getLike() {
        return like_num;
    }

    public void setLike(int like) {
        this.like_num = like;
    }

    public int getClick() {
        return click_num;
    }

    public void setClick(int click) {
        this.click_num = click;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAudit() {
        return Audit;
    }

    public void setAudit(int audit) {
        Audit = audit;
    }


    @Override
    public String toString() {
        return "articleDate{" +
                "article_name='" + article_name + '\'' +
                ", article_id='" + article_id + '\'' +
                ", article_label='" + article_label + '\'' +
                ", user_id='" + user_id + '\'' +
                ", like=" + like_num +
                ", click=" + click_num +
                ", Audit=" + Audit +
                ", article='" + article + '\'' +
                ", date=" + date +
                '}';
    }
}

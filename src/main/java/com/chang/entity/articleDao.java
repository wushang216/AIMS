package com.chang.entity;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface articleDao {
    int GetArticleNum();
    int GetArticleAllNum();
    List<article> GetArticle(int n);
    List<articleDate> GetAllArticle();
    int GetArticleNumByUser(String id);
    List<article> GetArticleByUser(@Param("id") String id,@Param("n") int n);
    articleDate GetArticleInformation(String article_id);
    List<article> GetArticleByName(String name);
    int postArticle(articleDate articleDate);
    int rewrite(articleDate articleDate);
    int Audit(@Param("id") String article_id,@Param("audit")String audit);
    int click(@Param("id") String article_id);
    List<article> articleByLike();
    List<article> articleByClick();
    List<article> GetArticleByLabel(String name);
    String getLabel(String Key);
}

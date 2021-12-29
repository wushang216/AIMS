package com.chang.dao;

import com.chang.entity.article;
import com.chang.entity.articleDao;
import com.chang.entity.articleDate;
import com.chang.entity.user;
import com.chang.utils.MyBatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class operateArticle {
    /**
     * 获取文章的数量
     * @return
     */
    public int GetArticleNum(){
        int num;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            num = mapper.GetArticleNum();
        }
        return num;
    }
    /**
     * 获取所有文章的列表
     * @return
     */
    public List<articleDate> GetArticle(){
        List<articleDate> articles;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articles = mapper.GetAllArticle();
        }
        return articles;
    }
    /**
     * 获取文章的列表
     * @return
     */
    public List<article> GetArticle(int n){
        List<article> articles;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articles = mapper.GetArticle((n-1)*6);
        }
        return articles;
    }

    /**
     * 获取文章内容
     * @param articleDate
     * @return
     */
    public articleDate GetArticleInformation(articleDate articleDate){
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articleDate = mapper.GetArticleInformation(articleDate.getArticle_id());
        }
        return articleDate;
    }

    /**
     * 由搜索栏提供关键字进行模糊查询
     * @param name
     * @return
     */
    public List<article> GetArticleByName(String name){
        List<article> articles;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articles = mapper.GetArticleByName("%"+name+"%");
            for (article article:articles) {
                System.out.println(article.getArticle_name());
            }
        }
        return articles;
    }

    /**
     * 发布文章
     * @param articleDate
     * @return
     */
    public int postArticle(articleDate articleDate){
        int i;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            i = mapper.postArticle(articleDate);
            if (i == 1){
                sqlSession.commit();
            }
        }
        return i;
    }
    /**
     * 重写文章
     * @param articleDate
     * @return
     */
    public int rewrite(articleDate articleDate){
        int i;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            i = mapper.rewrite(articleDate);
            System.out.println(i);
            if (i == 1){
                sqlSession.commit();
            }
        }
        return i;
    }

    /**
     * 获取单一用户的文章
     * @param id
     * @param n
     * @return
     */
    public List<article> GetArticleByUser(String id,int n){
        List<article> articles;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articles = mapper.GetArticleByUser(id, (n-1)*6);
        }
        return articles;
    }

    /**
     * 根据用户id来获取该用户的文章的数量
     * @param id
     * @return
     */
    public int GetArticleNumByUser(String id){
        int num;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            num = mapper.GetArticleNumByUser(id);
        }
        return num;
    }

    /**
     * 将用户封号或者解封
     * @param article_id
     * @param audit
     * @return
     */
    public int Audit(@Param("id") String article_id, @Param("audit")String audit){
        int Ok;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            Ok = mapper.Audit(article_id, audit);
            sqlSession.commit();
        }
        return Ok;
    }

    /**
     * 根据用户点击来添加点击数
     * @param article_id
     * @return
     */
    public int Click(@Param("id") String article_id){
        int Ok;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            Ok = mapper.click(article_id);
            sqlSession.commit();
        }
        return Ok;
    }

    /**
     *
     */
    public List<article> articleByLike(){
        List<article>  articles;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articles = mapper.articleByLike();
        }
        return articles;
    }
    /**
     *
     */
    public List<article> articleByClick() {
        List<article> articles;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            articleDao mapper = sqlSession.getMapper(articleDao.class);
            articles = mapper.articleByClick();
        }
        return articles;
    }
}

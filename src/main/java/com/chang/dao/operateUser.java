package com.chang.dao;

import com.chang.entity.user;
import com.chang.entity.userDao;
import com.chang.entity.userDate;
import com.chang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class operateUser {
    /**
     * 获取用户登录信息
     * @param user_id 用户id
     * @return 放回包括用户账户id和密码的信息
     */
    public userDate Login(String user_id){
        userDate userDate = new userDate();
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            userDate.setUser_id(user_id);
            userDate = mapper.logIn(userDate);
        }
        return userDate;
    }

    /**
     * 获取用户基础信息
     * @param user_id 用户id
     * @return 返回包括用户账户id、用户名和Email的信息
     */
    public user GetUser(String user_id){
        user user = new user();
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            user.setUser_id(user_id);
            user = mapper.getUser(user);
        }
        return user;
    }

    /**
     *
     * @param user_id
     * @return
     */
    public userDate GetUserDate(String user_id){
        userDate user;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            user = mapper.getUserDate(user_id);
        }
        return user;
    }

    /**
     * 用于注册
     * @param account 用户账户
     * @param password 用户密码
     * @return 注册成功返回true
     */
    public boolean registration(String account , String password){
        int i = 0;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            userDate userDate = new userDate();
            userDate.setUser_id(account);
            if (mapper.logIn(userDate) == null){
                userDate.setUser_password(password);
                i = mapper.registration(userDate);
                sqlSession.commit();
            }
        }
        return i == 1;
    }

    /**
     * Email登录判定是否存在该Email
     * @param email 是否存在Email
     * @return 存在则返回user
     */
    public userDate getEmail(String email){
        userDate userDate;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            userDate = mapper.getEmail(email);
            System.out.println("该账户存在");
        }
        return userDate;
    }

    /**
     * 用于更新信息
     * @param userDate
     * @return
     */
    public boolean modify(userDate userDate){
        boolean modify;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            modify = mapper.modify(userDate);
            sqlSession.commit();
        }
        return modify;
    }

    /**
     * 获取用户的所有信息，管理者功能
     * @param name
     * @return
     */
    public List<userDate> getAllUser(String name){
        List<userDate> allUser;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            allUser =  mapper.getAllUser(name);
        }
        return allUser;
    }

    /**
     * 将用户封号
     * @param id 被操作用户的id
     * @return
     */
    public int sealUser(String id){
        int i;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            mapper.sealUserOneStep(id);
            i = mapper.sealUserTowStep(id);
            sqlSession.commit();
        }
        return i;
    }

    /**
     * 将用户解封
     * @param id 被操作对象的id
     * @return
     */
    public int unSealUser(String id){
        int i;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            userDao mapper = sqlSession.getMapper(userDao.class);
            i = mapper.unSealUser(id);
            sqlSession.commit();
        }
        return i;
    }
}

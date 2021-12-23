package com.chang.entity;

import com.chang.entity.user;
import com.chang.entity.userDate;

import java.util.List;

public interface userDao {
    /**
     *  获取用户信息，通过用户id
     * @param user
     * @return
     */
    user getUser(user user);

    /**
     * 用户注册
     * @param userDate
     * @return
     */
    int registration(userDate userDate);

    /**
     * 获取用户密码
     * @param userDate 密码和账号
     * @return 如果用户存在的话返回用户信息
     */
    userDate logIn(userDate userDate);

    /**
     *
     * @param Email
     * @return
     */
    userDate getEmail(String Email);

    /**
     *
     * @param userDate
     * @return
     */
    boolean modify(userDate userDate);

    /**
     * 获取所有用户的信息
     * @return
     */
    List<userDate> getAllUser(String name);

    int sealUserOneStep(String id);
    int sealUserTowStep(String id);
    int unSealUser(String id);
}

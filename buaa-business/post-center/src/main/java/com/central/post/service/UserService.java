package com.central.post.service;

import com.central.post.model.User;

public interface UserService {
    /**
     * 登录服务
     *
     * @param uid      用户id
     * @param password 密码
     * @return 用户信息
     */
    User login(Integer uid, String password);

    /**
     * 注册服务
     *
     * @param user 用户对象
     * @return 用户id
     */
    Integer register(User user);

    /**
     * 获取用户信息
     *
     * @param uid 用户id
     * @return 用户信息
     */
    User getUserInfo(Integer uid);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void updateUserInfo(User user);

    /**
     * 更新用户邮箱
     *
     * @param user     用户对象
     * @param password 密码
     * @param email    邮箱
     */
    void updateUserEmail(User user, String password, String email);

    /**
     * 更新密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param user        用户对象
     */
    void updatePassword(String oldPassword, String newPassword, User user);
}

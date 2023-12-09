package com.central.post.service;

import com.central.post.model.User;

import com.central.post.mapper.UserMapper;
import com.central.post.exception.Exceptions;
import com.central.post.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(Integer uid, String password) {
        User user = userMapper.getUserByUid(uid);
        if (user == null) throw new ServiceException(Exceptions.UserNotFoundException);
        if (!password.equals(user.getPassword())) throw new ServiceException(Exceptions.UserPasswordNotMatch);
        return user;
    }

    @Override
    public Integer register(User user) {
        Integer res = userMapper.insertUser(user);
        if (res != 1) throw new ServiceException(Exceptions.UserInsertException);
        return user.getUid();//返回id值
    }

    @Override
    public User getUserInfo(Integer uid) {
        User user = userMapper.getUserByUid(uid);
        if (user == null) throw new ServiceException(Exceptions.UserNotFoundException);
        return user;
    }

    @Override
    public void updateUserInfo(User user) {
        Integer res = userMapper.updateUserInfo(user);
        if (res != 1) throw new ServiceException(Exceptions.UserUpdateException);
    }

    @Override
    public void updateUserEmail(User user, String password, String email) {
        String pwd = user.getPassword();
        if (!pwd.equals(password)) throw new ServiceException(Exceptions.UserPasswordNotMatch);
        user.setEmail(email);
        Integer res = userMapper.updateUserInfo(user);
        if (res != 1) throw new ServiceException(Exceptions.UserUpdateException);
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword, User user) {
        if (!oldPassword.equals(user.getPassword())) throw new ServiceException(Exceptions.UserPasswordNotMatch);
        Integer res = userMapper.updateUserPassword(newPassword, user.getUid());
        if (res != 1) throw new ServiceException(Exceptions.UserUpdateException);
    }
}

package com.central.post.controller;

import com.central.post.model.Post;
import com.central.post.model.User;
import com.central.post.service.TokenService;
import com.central.post.service.UserService;
import com.central.post.util.JsonResult;
import com.central.post.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.mail.MessagingException;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    private UserService userService;
    private TokenService tokenService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PassToken
    @RequestMapping("login")
    public JsonResult<Map<String, Object>> login(Integer uid, String password) {
        User u = userService.login(uid, password);
        String token = tokenService.getToken(u);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", u);
        map.put("token", token);
        return new JsonResult<>(ok, map);
    }

    @PassToken
    @RequestMapping("register")
    public JsonResult<Map<String, Integer>> register(User user) {
        Integer res = userService.register(user);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("uid", res);
        return new JsonResult<>(ok, map);
    }

    @NeedToken
    @RequestMapping("getUserInfoByUid")
    public JsonResult<User> getUserInfoByUid(Integer uid) {
        User user = userService.getUserInfo(uid);
        return new JsonResult<>(ok, user);
    }

    @RequestMapping("getUserList")
    public JsonResult<List<User>> getUserList() {
        List<User> users = userService.getAllUser();
        JsonResult<List<User>> jsonResult = new JsonResult<>();
        jsonResult.setState(ok);
        jsonResult.setData(users);
        return jsonResult;
    }

    @NeedToken
    @RequestMapping("updateUserInfo")
    public JsonResult<Void> updateUserInfo(User u, @CurrentUser User user) {
        user.setAvatar(u.getAvatar());
        user.setUsername(u.getUsername());
        userService.updateUserInfo(user);
        return new JsonResult<>(ok);
    }

    @NeedToken
    @RequestMapping("updateEmail")
    public JsonResult<Void> updateEmail(String password, String email, @CurrentUser User user) {
        userService.updateUserEmail(user, password, email);
        return new JsonResult<>(ok);
    }

    @NeedToken
    @RequestMapping("updatePassword")
    public JsonResult<Void> updatePassword(String oldPassword, String newPassword, @CurrentUser User user) {
        userService.updatePassword(oldPassword, newPassword, user);
        return new JsonResult<>(ok);
    }

    @PassToken
    @RequestMapping("test")
    public JsonResult<Void> test() {
        return new JsonResult<>(ok);
    }
}

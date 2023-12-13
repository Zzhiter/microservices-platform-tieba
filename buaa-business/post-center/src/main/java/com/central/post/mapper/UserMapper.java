package com.central.post.mapper;

import com.central.post.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据uid来查询数据
     * @param uid 用户自身成的uid
     * @return 如果找到对应用户则返回这个用户的数据；否则返回null
     */
    User getUserByUid(int uid);

    /**
     * 插入用户数据
     * @param user 用户的数据
     * @return 受影响的行数（增删改都有受影响的行数作为返回值，以此判断）
     */
    Integer insertUser(User user);

    List<User> getUserByName(String keyword);

    List<User> getUserList();

    Integer updateUserPassword(String password, Integer uid);

    Integer updateUserInfo(User user);
}

package com.central.post.service;

import com.central.post.model.Post;

import java.util.Date;
import java.util.List;

public interface PostService {
    /**
     * 发布帖子（更改）
     *
     * @param post
     * @return pid
     */
    Integer publishPost(Post post);

    /**
     * 查看帖子
     *
     * @param pid
     * @return 帖子
     */
    Post getPostInfo(Integer pid);

    /**
     * 更改帖子
     *
     * @param post
     */
    Integer ReEditPost(Post post);

    /**
     * 搜索帖子（暂时只有标题
     *
     * @param keyword
     * @return Post列表
     */
    List<Post> getPostByKeyword(String keyword, Date date);

    List<Post> getPostByType(Integer type, Date date);

    List<Post> getAllPost(Date date);

    /**
     * 根据uid获取用户post
     *
     * @param uid 用户id
     * @return list
     */
    List<Post> getPostByUid(Integer uid, Date date);


    Integer deletePost(Post post);
}

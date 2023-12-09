package com.central.post.mapper;

import com.central.post.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PostMapper {

    Post getPostByPid(int pid);

    Integer insertPost(Post post);

    List<Post> getPostByKeyword(@Param("keyword") String keyword, @Param("date") Date date);//暂时只搜索标题

    List<Post> getPostByType(@Param("type") Integer type, @Param("date") Date date);

    List<Post> getAllPost(Date date);

    List<Post> getPostByUid(@Param("uid") Integer uid, @Param("date") Date date);

    Integer ReEditPost(Post post);

    Integer PostComment(Integer pid);

    Integer PostDeleteComment(Integer pid);

    Integer deletePost(Post post);

    Integer deletePostThenComment(Post post);

}

package com.central.post.service;

import com.central.post.model.Post;
import com.central.post.exception.Exceptions;
import com.central.post.exception.ServiceException;
import com.central.post.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostMapper postMapper;

    @Autowired
    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public Integer publishPost(Post post) {
        post.setDate(new Date());
        post.setComments(0);
        post.setType(0);
        Integer res = postMapper.insertPost(post);
        if (res != 1) throw new ServiceException(Exceptions.PostInsertException);
        return post.getPid();
    }

    @Override
    public Post getPostInfo(Integer pid) {
        Post post = postMapper.getPostByPid(pid);
        if (post == null) throw new ServiceException(Exceptions.PostNotFound);
        return post;
    }

    @Override
    public Integer ReEditPost(Post post) {
        Integer res = postMapper.ReEditPost(post);
        if (res != 1) throw new ServiceException(Exceptions.PostReEditErr);
        return post.getPid();
    }

    @Override
    public List<Post> getPostByKeyword(String keyword, Date date) {
        List<Post> posts = postMapper.getPostByKeyword(keyword, date);
        if (posts.size() == 0) throw new ServiceException(Exceptions.PostSearchNone);
        return posts;
    }

    @Override
    public List<Post> getPostByType(Integer type, Date date) {
        List<Post> posts = postMapper.getPostByType(type, date);
        if (posts.size() == 0) throw new ServiceException(Exceptions.PostSearchNone);
        return posts;
    }

    @Override
    public List<Post> getAllPost(Date date) {
        List<Post> posts = postMapper.getAllPost(date);
        if (posts.size() == 0) throw new ServiceException(Exceptions.PostSearchNone);
        return posts;
    }

    @Override
    public List<Post> getPostByUid(Integer uid, Date date) {
        return postMapper.getPostByUid(uid, date);
    }

    @Override
    public Integer deletePost(Post post){
        Integer res1 = postMapper.deletePost(post);
        Integer res2 = postMapper.deletePostThenComment(post);
        return res1 & res2;
    }
}

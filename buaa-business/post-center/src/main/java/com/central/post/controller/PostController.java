package com.central.post.controller;

import com.central.post.model.*;
import com.central.post.service.PostService;
import com.central.post.service.CommentService;
import com.central.post.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
@RestController
@RequestMapping("post")
public class PostController extends BaseController {
    private PostService postService;
    private CommentService commentService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/postInfo")
    public JsonResult<Map<String, Object>> getPostInfo(Integer pid) {
        Post res = postService.getPostInfo(pid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("post", res);
        return new JsonResult<>(ok, map);

    }

    @RequestMapping("PublishPost")
    public JsonResult<Map<String, Integer>> PublishPost(Post post, Integer uid) {
        post.setUid(uid);
        Integer res = postService.publishPost(post);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pid", res);
        return new JsonResult<>(ok, map);
    }

    @RequestMapping("DeletePost")
    public JsonResult<Void> DeletePost(Post post) {
        postService.deletePost(post);
        return new JsonResult<>(ok);
    }

    @RequestMapping("getPostList")
    public JsonResult<List<Post>> getPostList() {
        Date d = new Date();
        List<Post> list = postService.getPostByType(1, d);
        JsonResult<List<Post>> jsonResult = new JsonResult<>();
        jsonResult.setState(ok);
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping("getPostListByUid")
    public JsonResult<List<Post>> getPostListByUid(Integer uid) {
        Date d = new Date();
        List<Post> list = postService.getPostByUid(uid, d);
        JsonResult<List<Post>> jsonResult = new JsonResult<>();
        jsonResult.setState(ok);
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping("getPostListByKeyword")
    public JsonResult<List<Post>> getPostListByKeyword(String keyword) {
        Date d = new Date();
        List<Post> list = postService.getPostByKeyword(keyword, d);
        JsonResult<List<Post>> jsonResult = new JsonResult<>();
        jsonResult.setState(ok);
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping("ReEditPost")
    public JsonResult<Map<String, Integer>> ReEditPost(Post post) {
        Integer res = postService.ReEditPost(post);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pid", res);
        return new JsonResult<>(ok, map);
    }

    @RequestMapping("commentPost")
    public JsonResult<PComment> commentPost(PComment pComment) {
        pComment.setDate(new Date());
        PComment res = commentService.commentPost(pComment);
        return new JsonResult<>(ok, res);
    }

    @RequestMapping("getCommentInfo")
    public JsonResult<Map<String, Object>> getCommentInfo(Integer cid) {
        PComment res = commentService.getCommentInfo(cid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Comment", res);
        return new JsonResult<>(ok, map);

    }

    @RequestMapping("getCommentByPid")
    public JsonResult<List<PComment>> getCommentByPid(Integer pid, Integer startCid) {
        List<PComment> list = commentService.getCommentByPid(pid, startCid);
        JsonResult<List<PComment>> jsonResult = new JsonResult<>();
        jsonResult.setState(ok);
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping("DeleteComment")
    public JsonResult<Void> DeleteComment(PComment pComment) {
        commentService.DeleteComment(pComment);
        return new JsonResult<>(ok);
    }
}

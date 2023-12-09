package com.central.post.service;

import com.central.post.model.PComment;

import java.util.List;

public interface CommentService {
    /**
     * 评论帖子
     *
     * @param pComment 评论对象
     * @return cid 评论的id
     */
    PComment commentPost(PComment pComment);

    /**
     * 查看评论
     *
     * @param cid 评论id
     * @return 评论的详情
     */
    PComment getCommentInfo(Integer cid);

    /**
     * 根据pid获取评论
     *
     * @param pid 帖子id
     * @return list
     */
    List<PComment> getCommentByPid(Integer pid, Integer startCid);

    /**
     * 删除评论
     *
     * @param pComment 评论对象
     */
    void DeleteComment(PComment pComment);
}

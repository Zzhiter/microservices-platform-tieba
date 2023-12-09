package com.central.post.mapper;

import com.central.post.model.PComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PCommentMapper {
    /**
     * 根据cid获取评论内容
     *
     * @param cid 评论编号
     * @return 评论的信息
     */
    PComment getPCommentByCid(int cid);

    /**
     * 根据帖子id获取评论列表
     *
     * @param pid      帖子id
     * @param startCid 开始的cid
     * @return 评论列表
     */
    List<PComment> getPCommentByPid(@Param("pid") int pid, @Param("startCid") Integer startCid);

    /**
     * 根据用户查看评论
     *
     * @param uid 帖子id
     * @return 评论列表
     */
    List<PComment> getPCommentByUid(int uid);

    /**
     * 对某个帖子进行评论
     *
     * @param pComment 评论相关
     * @return 受影响的行数
     */
    Integer commentPost(PComment pComment);

    Integer DeleteComment(PComment pComment);
}

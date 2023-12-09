package com.central.post.service;

import com.central.post.model.PComment;
import com.central.post.mapper.PCommentMapper;
import com.central.post.mapper.PostMapper;
import com.central.post.exception.Exceptions;
import com.central.post.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private PCommentMapper pCommentMapper;
    private PostMapper postMapper;

    @Autowired
    public void setPCommentMapper(PCommentMapper pCommentMapper) {
        this.pCommentMapper = pCommentMapper;
    }

    @Autowired
    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public PComment commentPost(PComment pComment) {
        pComment.setDate(new Date());
        Integer res = pCommentMapper.commentPost(pComment);
        if (res != 1) throw new ServiceException(Exceptions.commentPostException);
        Integer res1 = postMapper.PostComment(pComment.getPid());
        if (res1 != 1) throw new ServiceException(Exceptions.commentPostException);
        return pComment;
    }

    @Override
    public PComment getCommentInfo(Integer cid) {
        PComment pComment = pCommentMapper.getPCommentByCid(cid);
        if (pComment == null) throw new ServiceException(Exceptions.PCommentNotFound);
        return pComment;
    }

    @Override
    public List<PComment> getCommentByPid(Integer pid, Integer startCid) {
        return pCommentMapper.getPCommentByPid(pid, startCid);
    }

    @Override
    public void DeleteComment(PComment pComment) {
        Integer c_pid = pCommentMapper.getPCommentByCid(pComment.getCid()).getPid();
        Integer res = pCommentMapper.DeleteComment(pComment);
        if (res < 1) throw new ServiceException(Exceptions.CommentDeleteException);
        Integer res1 = postMapper.PostDeleteComment(c_pid);
        if (res1 != 1) throw new ServiceException(Exceptions.CommentDeleteException);
    }
}

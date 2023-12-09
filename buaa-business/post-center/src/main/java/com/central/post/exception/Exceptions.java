package com.central.post.exception;

public enum Exceptions {
    //User异常
    UserInsertException(1000, "用户信息插入异常"),
    UserNotFoundException(1001, "用户不存在"),
    UserUpdateException(1002, "用户更新异常"),
    UserPasswordNotMatch(1003, "用户密码错误"),
    UserMailNotMatch(1004, "用户邮箱不匹配"),
    SubscribeInsertException(1005, "关注用户异常"),
    SubscribeDeleteException(1006, "取消关注用户异常"),
    CollectionInsertException(1007, "收藏帖子异常"),
    CollectionDeleteException(1008, "取消收藏帖子异常"),
    //Token异常
    TokenNotFoundException(2000, "未找到token"),

    TokenDecodeException(2001, "token解码异常"),
    TokenVerifyException(2002, "token验证异常"),
    //Message异常
    MessageInsertException(3000, "消息插入异常"),
    MessageUpdateException(3001, "消息更新异常"),
    //File异常
    FileEmptyException(4000, "文件不存在"),
    //post异常
    PostInsertException(5000, "帖子发布异常"),
    PostNotFound(5001, "帖子不存在"),
    PostReEditErr(5002, "帖子更新异常"),
    PostSearchNone(5003, "未找到含有该关键词的帖子"),
    PLikeInsertException(5004, "帖子点赞异常"),
    PLikeDeleteException(5005, "帖子取消点赞异常"),
    PostHaveBeenLikedException(5006,"帖子已经点赞过了"),
    //评论异常
    commentPostException(6000, "评论帖子异常"),
    PCommentNotFound(6001, "评论不存在"),
    CommentDeleteException(6002, "删除评论异常"),
    CCommentException(6003, "评论评论失败"),
    ;

    private final Integer code;
    private final String message;

    Exceptions(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

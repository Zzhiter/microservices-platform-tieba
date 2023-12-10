package com.central.user.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("post")
public class Post {
    @TableId
    private Integer pid;
    private String title;
    private String text;
    private String date;
    private Integer comments;
    private Integer uid;
    private Integer type;
    private String tenant_id;
}

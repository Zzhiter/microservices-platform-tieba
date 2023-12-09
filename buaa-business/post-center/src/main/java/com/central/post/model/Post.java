package com.central.post.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Post {
    private Integer pid;
    private Integer uid;
    private Integer type;
    private String title;
    private Date date;
    private Integer comments;
    private String text;
}
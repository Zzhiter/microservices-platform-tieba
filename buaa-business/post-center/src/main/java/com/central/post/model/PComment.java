package com.central.post.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class PComment {
    private Integer cid;
    private Integer pid;
    private Integer uid;
    private String comment;
    private Date date;
}

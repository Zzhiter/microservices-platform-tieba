package com.central.post.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private Integer uid;
    private String username;
    @JsonIgnore
    private String password;//不会被传到前端
    private String avatar = "";
    private String email;
}

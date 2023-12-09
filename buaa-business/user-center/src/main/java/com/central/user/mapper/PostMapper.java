package com.central.user.mapper;

import com.central.user.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PostMapper {

    // Update method for updating a post by its ID
    void updateByPid(Post post);
}

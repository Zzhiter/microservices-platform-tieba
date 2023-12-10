package com.central.user.mapper;

import com.central.user.model.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PostMapper {

    // Update method for updating a post by its ID
    void updateByPid(Post post);

    void insert(Post postEntity);

    @Select("SELECT * FROM post WHERE pid = #{pid}")
    Post selectById(@Param("pid") int pid);

    @Delete("DELETE FROM post WHERE pid = #{pid}")
    void deleteById(@Param("pid") Long pid);
}

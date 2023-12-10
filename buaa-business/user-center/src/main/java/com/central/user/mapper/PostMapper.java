package com.central.user.mapper;

import com.central.user.model.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Update({
            "<script>",
            "UPDATE post SET type = #{postType} WHERE pid IN",
            "<foreach collection='pids' item='pid' open='(' separator=',' close=')'>",
            "#{pid}",
            "</foreach>",
            "</script>"
    })
    void batchUpdatePostTypeByPid(@Param("postType") int postType, @Param("pids") List<Long> pids);

}

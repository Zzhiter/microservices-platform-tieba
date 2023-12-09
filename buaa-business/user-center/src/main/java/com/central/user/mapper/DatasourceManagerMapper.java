package com.central.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.db.mapper.SuperMapper;
import com.central.user.model.SysFields;
import com.central.user.model.SysTables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author buaa
 */
@Component
@Mapper
public interface DatasourceManagerMapper extends SuperMapper<SysTables> {
    List<Map<String, Object>> queryList(Page<Map<String, Object>> page, @Param("p") Map<String, Object> map);

    // 新增方法：查询这个表的数据
    List<Map<String, Object>> queryAll(@Param("page") int page, @Param("pageSize") int pageSize, @Param("tableName") String tableName);

    List<String> queryTableNames();

    Long queryTableIdByName(String tableName);

    // Updated method: Update based on tableName
    void updateTable(@Param("tableName") String tableName, @Param("params") Map<String, Object> params);
}

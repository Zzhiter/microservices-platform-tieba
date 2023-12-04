package com.central.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.db.mapper.SuperMapper;
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

    // 新增方法：查询所有数据
    List<Map<String, Object>> queryAll();
}

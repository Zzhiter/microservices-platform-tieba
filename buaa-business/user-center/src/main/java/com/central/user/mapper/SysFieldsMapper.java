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
public interface SysFieldsMapper extends SuperMapper<SysFields> {

    List<SysFields> queryTableColumns(Long tableId);
}
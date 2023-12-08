package com.central.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.PageResult;
import com.central.common.service.impl.SuperServiceImpl;
import com.central.user.mapper.DatasourceManagerMapper;
import com.central.user.mapper.SysFieldsMapper;
import com.central.user.model.SysFields;
import com.central.user.model.SysTables;
import com.central.user.service.IDatasourceManagerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author buaa
 */
@Slf4j
@Service
public class DatasourceManagerServiceImpl extends SuperServiceImpl<DatasourceManagerMapper, SysTables> implements IDatasourceManagerService {
    @Resource
    DatasourceManagerMapper datasourceManagerMapper;

    @Resource
    SysFieldsMapper sysFieldsMapper;

    @Override
    public PageResult<Map<String, Object>> queryList(Map<String, Object> map) {
        Page<Map<String, Object>> page = new Page<>(MapUtils.getInteger(map, "page", 1), MapUtils.getInteger(map, "limit"));

        List<Map<String, Object>> list = datasourceManagerMapper.queryList(page, map);
        return PageResult.<Map<String, Object>>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public PageResult<Map<String, Object>> queryAll(int page, int pageSize, String tableName) {
        List<Map<String, Object>> allData = datasourceManagerMapper.queryAll(page, pageSize, tableName); // 假设你有一个查询所有数据的方法

        return PageResult.<Map<String, Object>>builder()
                .data(allData)
                .code(0)
                .count((long) allData.size()) // 设置总数为数据的总条数
                .build();
    }

    @Override
    public PageResult<String> queryTableNames() {
        List<String> tableNames = datasourceManagerMapper.queryTableNames();

        return PageResult.<String>builder()
                .data(tableNames)
                .code(0)
                .count((long)tableNames.size())
                .build();
    }

    @Override
    public PageResult<SysFields> queryTableColumns(String tableName) {
        Long tableId = this.queryTableIdByName(tableName);
        List<SysFields> tableColumns = sysFieldsMapper.queryTableColumns(tableId);

        return PageResult.<SysFields>builder()
                .data(tableColumns)
                .code(0)
                .count((long)tableColumns.size())
                .build();
    }

    @Override
    public Long queryTableIdByName(String tableName) {
        Long tableId = datasourceManagerMapper.queryTableIdByName(tableName);
        return tableId;
    }

}

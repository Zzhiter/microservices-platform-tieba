package com.central.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.PageResult;
import com.central.common.service.impl.SuperServiceImpl;
import com.central.user.mapper.DatasourceManagerMapper;
import com.central.user.model.SysTables;
import com.central.user.service.IDatasourceManagerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
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

    @Override
    public PageResult<Map<String, Object>> queryList(Map<String, Object> map) {
        Page<Map<String, Object>> page = new Page<>(MapUtils.getInteger(map, "page", 1), MapUtils.getInteger(map, "limit"));

        List<Map<String, Object>> list = datasourceManagerMapper.queryList(page, map);
        return PageResult.<Map<String, Object>>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public PageResult<Map<String, Object>> queryAll() {
        List<Map<String, Object>> allData = datasourceManagerMapper.queryAll(); // 假设你有一个查询所有数据的方法

        return PageResult.<Map<String, Object>>builder()
                .data(allData)
                .code(0)
                .count((long) allData.size()) // 设置总数为数据的总条数
                .build();
    }
}

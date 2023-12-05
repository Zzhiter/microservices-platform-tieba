package com.central.user.service;

import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;
import com.central.user.model.SysTables;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author buaa
 */
@Service
public interface IDatasourceManagerService extends ISuperService<SysTables> {
    PageResult queryList(Map<String, Object> map);
    PageResult queryAll();
    PageResult queryTableNames();

    PageResult queryTableColumns(String tableName);

    Long queryTableIdByName(String tableName);
}

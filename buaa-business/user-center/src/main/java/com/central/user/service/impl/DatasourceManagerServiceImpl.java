package com.central.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.PageResult;
import com.central.common.service.impl.SuperServiceImpl;
import com.central.user.mapper.DatasourceManagerMapper;
import com.central.user.mapper.PostMapper;
import com.central.user.mapper.SysFieldsMapper;
import com.central.user.model.Post;
import com.central.user.model.SysFields;
import com.central.user.model.SysTables;
import com.central.user.service.IDatasourceManagerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Resource
    PostMapper postMapper;

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

    private <T> T constructEntityObject(Map<String, Object> params, Class<T> entityClass) throws Exception {
        // Create an instance of the entity class
        T entityObject = entityClass.getDeclaredConstructor().newInstance();

        // Assume your entity class has setter methods for each field
        for (Field field : entityClass.getDeclaredFields()) {
            String fieldName = field.getName();

            // Check if the params map contains a value for the field
            List<String> integerFields = Arrays.asList("pid", "comments", "type", "uid");
            boolean isIntegerField = integerFields.contains(fieldName);

// Get the value from the params map
            Object value = params.get(fieldName);

            if (value != null) {
                if (isIntegerField) {
                    // Check if the value is an Integer before parsing
                    if (value instanceof Integer) {
                        // If it's already an Integer, no need to parse
                        // You can directly assign it to the target field
                        // For example, if you have a Post object, use post.setUid((Integer) value);
                    } else if (value instanceof String) {
                        // If it's a String, parse it to Integer
                        value = Integer.parseInt((String) value);
                    } else {
                        // Handle other types if necessary
                        throw new IllegalArgumentException("Unsupported type for field: " + fieldName);
                    }
                }
                // Handle other field types or leave them as they are
            }

            // Use reflection to set the value in the entity object
            Method setterMethod = entityClass.getMethod("set" + StringUtils.capitalize(fieldName), field.getType());
            setterMethod.invoke(entityObject, value);
        }

        return entityObject;
    }


    @Override
    public PageResult updateTable(String tableName, Map<String, Object> params) {
        try {
            // 这里维护一个映射，通过tableName，获取对应的table的update方法
            if (Objects.equals(tableName, "post")) {
                // Assuming you have a Post entity class
                Class<Post> postClass = Post.class;

                // Construct a Post object using the provided parameters
                Post postEntity = constructEntityObject(params, postClass);

                // Check if the record exists
                Post existingPost = postMapper.selectById(postEntity.getPid());

                if (existingPost != null) {
                    // If the record exists, update it
                    postMapper.updateByPid(postEntity);
                } else {
                    // If the record doesn't exist, insert it
                    postMapper.insert(postEntity);
                }

                // Handle the result of the updateCount as needed
            }

            // Update was successful
            return PageResult.<SysFields>builder()
                    .data(null)
                    .code(0)
                    .count(0L)
                    .build();

        } catch (Exception e) {
            log.error("Error updating table", e);
            return PageResult.<SysFields>builder()
                    .data(null)
                    .code(-1)
                    .count(0L)
                    .build();
        }
    }

}

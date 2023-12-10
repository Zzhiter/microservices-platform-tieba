package com.central.user.controller;

import com.central.common.model.PageResult;
import com.central.user.service.IDatasourceManagerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: buaa
 */
@RestController
@Api(tags = "数据表管理")
@RequestMapping("/tables")
public class DatasourceManagerController {

    @Autowired
    @Qualifier("datasourceManagerServiceImpl") // 指定具体的bean名称
    private IDatasourceManagerService datasourceManagerService;

    @ResponseBody
    @GetMapping
    public PageResult getTableList(@RequestParam Map<String, Object> params) {
        return datasourceManagerService.queryList(params);
    }

    @ResponseBody
    @GetMapping("/all")
    public PageResult getAllTables(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam String tableName
    ) {
        // 在这里使用 page、pageSize、tableName 进行查询操作
        return datasourceManagerService.queryAll(page, pageSize, tableName);
    }


    @ResponseBody
    @GetMapping("/names")
    public PageResult getTableNames() {
        return datasourceManagerService.queryTableNames();
    }

    @ResponseBody
    @GetMapping("/columns")
    public PageResult getTableColumns(@RequestParam String tableName) {
        return datasourceManagerService.queryTableColumns(tableName);
    }

    // New endpoint for updating tables
    @ResponseBody
    @PostMapping("/{tableName}")
    public PageResult updateTable(@PathVariable String tableName, @RequestBody Map<String, Object> params) {

        return datasourceManagerService.updateTable(tableName, params);
    }

    @DeleteMapping("/{tableName}/{recordId}")
    public ResponseEntity<?> deleteRecord(@PathVariable String tableName, @PathVariable Long recordId) {
        try {
            if ("post".equals(tableName)) {
                // Assuming you have a method in your service to delete a record by ID
                datasourceManagerService.deleteRecordById(recordId);
                return ResponseEntity.ok().build();
            }
                return ResponseEntity.status(-1).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

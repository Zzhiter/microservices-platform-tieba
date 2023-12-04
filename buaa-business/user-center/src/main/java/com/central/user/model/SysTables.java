package com.central.user.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_tables")
public class SysTables {
    private Long tableId;

    private String tableName;

    private String tenantId;

    private String tableDescription;
}

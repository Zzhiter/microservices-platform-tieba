package com.central.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_fields")
public class SysFields {
    private Long fieldId;
    private Long tableId;
    private String fieldName;
    private String dataType;
    private boolean isNullable;
}

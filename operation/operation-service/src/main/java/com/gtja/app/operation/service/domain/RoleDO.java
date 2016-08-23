package com.gtja.app.operation.service.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by zhoubo on 16/7/26.
 */
@Data
@ToString(callSuper = true)
public class RoleDO extends BaseDO {
    private String name;
    private String description;
}

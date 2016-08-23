package com.gtja.app.operation.service.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by zhoubo on 16/8/4.
 */
@Data
@ToString(callSuper = true)
public class UserRoleDO extends BaseDO {
    private Long userId;
    private Long roleId;

}

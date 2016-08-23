package com.gtja.app.operation.service.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by zhoubo on 16/7/26.
 */
@Data
@ToString(callSuper = true)
public class UserDO extends BaseDO {
    private String userName;
    private String password;
    private String loginName;
    private String mobile;
    private String email;
    private byte gender;
}

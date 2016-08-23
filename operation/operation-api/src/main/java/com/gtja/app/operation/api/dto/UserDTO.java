package com.gtja.app.operation.api.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Created by zhoubo on 16/7/20.
 */
@Data
@ToString(callSuper = true)
public class UserDTO extends BaseDTO {
    private String userName;
    private String password;
    private String loginName;
    private String mobile;
    private String email;
    private byte gender;

}

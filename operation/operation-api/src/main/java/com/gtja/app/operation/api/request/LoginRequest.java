package com.gtja.app.operation.api.request;

import lombok.Data;

/**
 * Created by zhoubo on 16/8/10.
 */
@Data
public class LoginRequest {
    private String loginName;
    private String password;
}

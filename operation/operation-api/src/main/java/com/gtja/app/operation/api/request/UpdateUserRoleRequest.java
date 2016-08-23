package com.gtja.app.operation.api.request;

import lombok.Data;

import java.util.List;

/**
 * Created by zhoubo on 16/8/4.
 */
@Data
public class UpdateUserRoleRequest extends RequestHeader {
    private Long userId;
    private List<Long> roleIds;
}

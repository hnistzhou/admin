package com.gtja.app.operation.api.request;

import lombok.Data;

import java.util.List;

/**
 * Created by zhoubo on 16/8/4.
 */
@Data
public class UpdateRoleResourceRequest extends RequestHeader {
    private Long roleId;
    private List<Long> resourceIds;
}

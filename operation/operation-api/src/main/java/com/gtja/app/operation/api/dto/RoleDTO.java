package com.gtja.app.operation.api.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Created by zhoubo on 16/7/20.
 */
@Data
@ToString(callSuper = true)
public class RoleDTO extends BaseDTO {
    private String name;
    private String description;
}

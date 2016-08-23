package com.gtja.app.operation.service.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by zhoubo on 16/7/25.
 */
@Data
@ToString(callSuper = true)
public class ResourceDO extends BaseDO {
    private String name;
    private String description;
    private Long parentId;
    private String url;

    @Override
    public boolean equals(Object obj) {
        ResourceDO resourceDO = (ResourceDO) obj;
        if (this.getId() == resourceDO.getId()) {
            return true;
        }
        return false;
    }
}

package com.gtja.app.operation.api.common;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Created by zhoubo on 16/7/20.
 */
@Data
public class ResponsePagingDTO {
    private int page;
    private int size;
    private long totalSize;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

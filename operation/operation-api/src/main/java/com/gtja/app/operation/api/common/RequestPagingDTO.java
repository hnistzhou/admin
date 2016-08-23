package com.gtja.app.operation.api.common;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Created by zhoubo on 16/7/20.
 */
@Data
public class RequestPagingDTO {
    private int page;
    private int size;
    private String orderBy;

    public int getStart() {
        return (page - 1) * size;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

package com.gtja.app.operation.service.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhoubo on 16/7/25.
 */
@Data
public class BaseDO {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
}

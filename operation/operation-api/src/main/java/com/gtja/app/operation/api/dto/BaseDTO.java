package com.gtja.app.operation.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhoubo on 16/7/20.
 */
@Data
public class BaseDTO {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
}

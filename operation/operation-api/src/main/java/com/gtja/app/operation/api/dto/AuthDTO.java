package com.gtja.app.operation.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by zhoubo on 16/8/11.
 */
@Data
public class AuthDTO {
    private Long id;
    private String name;
    private String url;
    private List<AuthDTO> subResources;
}

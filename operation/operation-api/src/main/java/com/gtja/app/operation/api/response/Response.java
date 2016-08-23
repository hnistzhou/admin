package com.gtja.app.operation.api.response;

import com.gtja.app.operation.api.common.ResponsePagingDTO;
import lombok.Data;

/**
 * Created by zhoubo on 16/7/20.
 */
@Data
public class Response<T> {
    private T data;
    private String msg;
    private int code;
    private String codeMsg;
    private ResponsePagingDTO pagingVO;

    public static <T> Response<T> success(T data) {
        Response response = new Response();
        response.setData(data);
        response.setCode(0);
        return response;
    }

}

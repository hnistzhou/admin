package com.gtja.app.operation.service.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by zhoubo on 16/8/11.
 */
public class AuthUtil {

    public static Long getUserId(String token) {
        if (StringUtils.isNotBlank(token)) {
            return NumberUtils.toLong(token, 0);
        }
        return 0L;
    }
}

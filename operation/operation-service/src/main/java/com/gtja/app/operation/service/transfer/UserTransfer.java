package com.gtja.app.operation.service.transfer;

import com.gtja.app.operation.api.dto.UserDTO;
import com.gtja.app.operation.service.domain.UserDO;
import com.gtja.app.operation.service.util.Transfer;
import org.springframework.stereotype.Component;

/**
 * Created by zhoubo on 16/8/12.
 */
@Component
public class UserTransfer extends Transfer<UserDO, UserDTO> {
}

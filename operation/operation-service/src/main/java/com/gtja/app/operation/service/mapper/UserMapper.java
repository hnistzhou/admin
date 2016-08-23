package com.gtja.app.operation.service.mapper;

import com.gtja.app.operation.service.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhoubo on 16/7/26.
 */
public interface UserMapper {
    List<UserDO> getUsers(@Param("start") int start, @Param("size") int size);

    UserDO getUserById(Long id);

    long getUserCount();

    void addUser(UserDO userDO);

    void deleteUser(long id);

    void updateUser(UserDO userDO);

    UserDO getUser(@Param("loginName") String loginName, @Param("password") String password);
}

package com.gtja.app.operation.service.mapper;

import com.gtja.app.operation.service.domain.RoleDO;
import com.gtja.app.operation.service.domain.UserRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhoubo on 16/7/26.
 */
public interface RoleMapper {

    List<RoleDO> getRoles(@Param("start") int start, @Param("size") int size);

    RoleDO getRoleById(Long id);

    long getRoleCount();

    void addRole(RoleDO RoleDO);

    void deleteRole(long id);

    void updateRole(RoleDO roleDO);

    List<RoleDO> getAllRoles();

    List<RoleDO> getRolesByUser(Long userId);

    void addUserRoles(List<UserRoleDO> roleResourceDOs);

    void deleteUserRoleByUserId(Long userId);
}

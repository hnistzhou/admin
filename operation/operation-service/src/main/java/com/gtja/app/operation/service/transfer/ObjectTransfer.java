package com.gtja.app.operation.service.transfer;

import com.gtja.app.operation.api.dto.AuthDTO;
import com.gtja.app.operation.api.request.UpdateRoleResourceRequest;
import com.gtja.app.operation.api.request.UpdateUserRoleRequest;
import com.gtja.app.operation.service.domain.ResourceDO;
import com.gtja.app.operation.service.domain.RoleResourceDO;
import com.gtja.app.operation.service.domain.UserRoleDO;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhoubo on 16/7/25.
 */
public class ObjectTransfer {

    public static List<RoleResourceDO> toRoleResourceDOs(UpdateRoleResourceRequest request) {
        if (CollectionUtils.isEmpty(request.getResourceIds())) {
            return null;
        }
        Long roleId = request.getRoleId();
        if (roleId == null || roleId == 0) {
            return null;
        }
        List<RoleResourceDO> roleResourceDOs = new ArrayList<>();
        for (Long resourceId : request.getResourceIds()) {
            RoleResourceDO roleResourceDO = new RoleResourceDO();
            roleResourceDO.setResourceId(resourceId);
            roleResourceDO.setRoleId(roleId);
            roleResourceDOs.add(roleResourceDO);
        }
        return roleResourceDOs;
    }

    public static List<UserRoleDO> toUserRoleDO(UpdateUserRoleRequest request) {
        if (CollectionUtils.isEmpty(request.getRoleIds())) {
            return null;
        }
        Long userId = request.getUserId();
        if (userId == null || userId == 0) {
            return null;
        }
        List<UserRoleDO> userRoleDOs = new ArrayList<>();
        for (Long roleId : request.getRoleIds()) {
            UserRoleDO userRoleDO = new UserRoleDO();
            userRoleDO.setRoleId(roleId);
            userRoleDO.setUserId(userId);
            userRoleDOs.add(userRoleDO);
        }
        return userRoleDOs;
    }

    public static List<AuthDTO> toAuthDTOs(List<ResourceDO> resourceDOs) {
        if (CollectionUtils.isEmpty(resourceDOs)) {
            return null;
        }
        List<ResourceDO> distinctResourceDOs = resourceDOs.stream().distinct().collect(Collectors.toList());
        List<AuthDTO> roots = distinctResourceDOs.stream().distinct()
                .filter(resourceDO -> resourceDO.getParentId() == 0)
                .map(resourceDO -> toAuthDTO(resourceDO))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(roots)) {
            return null;
        }

        for (AuthDTO authDTO : roots) {
            for (ResourceDO resourceDO : distinctResourceDOs) {
                if (authDTO.getId() == resourceDO.getParentId()) {
                    List<AuthDTO> subResources = authDTO.getSubResources();
                    if (subResources == null) {
                        subResources = new ArrayList<>();
                        authDTO.setSubResources(subResources);
                    }
                    subResources.add(toAuthDTO(resourceDO));

                }
            }
        }
        return roots;
    }

    public static AuthDTO toAuthDTO(ResourceDO resourceDO) {
        if (resourceDO == null) {
            return null;
        }
        AuthDTO authDTO = new AuthDTO();
        authDTO.setId(resourceDO.getId());
        authDTO.setName(resourceDO.getName());
        authDTO.setUrl(resourceDO.getUrl());
        return authDTO;

    }
}
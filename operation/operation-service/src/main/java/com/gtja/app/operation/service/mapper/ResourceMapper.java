package com.gtja.app.operation.service.mapper;

import com.gtja.app.operation.service.domain.ResourceDO;
import com.gtja.app.operation.service.domain.RoleResourceDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhoubo on 16/7/25.
 */
public interface ResourceMapper {
    List<ResourceDO> getResources(@Param("start") int start, @Param("size") int size);
    
    ResourceDO getResourceById(Long id);

    long getResourceCount();
    void addResource(ResourceDO resourceDO);

    void deleteResource(long id);

    void updateResource(ResourceDO resourceDO);

    List<ResourceDO> getResourceByRoleId(long roleId);

    List<ResourceDO> getAllResources();

    void addRoleResource(List<RoleResourceDO> roleResourceDOs);

    void deleteRoleResourceByRoleId(Long roleId);

    List<ResourceDO> getResourcesByRoleIds(List<Long> roleIds);
}

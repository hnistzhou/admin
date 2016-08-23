package com.gtja.app.operation.api.service;

import com.gtja.app.operation.api.dto.*;
import com.gtja.app.operation.api.request.*;
import com.gtja.app.operation.api.response.Response;

import java.util.List;

/**
 * Created by zhoubo on 16/7/20.
 */
public interface SystemService {
    Response<List<ResourceDTO>> getResources(GetResourcesRequest request);

    Response<ResourceDTO> getResourceById(Long id);

    Response<UserDTO> getUserById(Long id);

    Response<RoleDTO> getRoleById(Long id);

    Response<Boolean> addResource(ResourceDTO resourceDto);

    Response<Boolean> removeResource(Long id);

    Response<Boolean> updateResource(ResourceDTO resourceDto);

    Response<List<UserDTO>> getUsers(GetUsersRequest request);

    Response<LoginDTO> login(String loginName, String password);

    Response<Boolean> register(UserDTO userDto);

    Response<Boolean> deleteUser(Long id);

    Response<Boolean> updateUser(UserDTO userDto);

    Response<List<RoleDTO>> getRoles(GetRolesRequest request);

    Response<Boolean> addRole(RoleDTO roleDto);

    Response<Boolean> deleteRole(Long id);

    Response<Boolean> updateRole(RoleDTO roleDto);

    Response<List<ResourceDTO>> getResourceByRoleId(Long roleId);

    Response<List<ResourceDTO>> getAllResources();

    Response<List<RoleDTO>> getRoleByUserId(Long userId);

    Response<List<RoleDTO>> getAllRoles();

    Response<Boolean> updateRoleResource(UpdateRoleResourceRequest request);

    Response<Boolean> updateUserRole(UpdateUserRoleRequest request);

    Response<List<AuthDTO>> getAuthByToken(RequestHeader request);

}

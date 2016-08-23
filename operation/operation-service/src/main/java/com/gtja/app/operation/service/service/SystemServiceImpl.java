package com.gtja.app.operation.service.service;

import com.gtja.app.operation.api.common.RequestPagingDTO;
import com.gtja.app.operation.api.common.ResponsePagingDTO;
import com.gtja.app.operation.api.dto.*;
import com.gtja.app.operation.api.request.*;
import com.gtja.app.operation.api.response.Response;
import com.gtja.app.operation.api.service.SystemService;
import com.gtja.app.operation.service.domain.*;
import com.gtja.app.operation.service.mapper.ResourceMapper;
import com.gtja.app.operation.service.mapper.RoleMapper;
import com.gtja.app.operation.service.mapper.UserMapper;
import com.gtja.app.operation.service.transfer.ObjectTransfer;
import com.gtja.app.operation.service.transfer.ResourceTransfer;
import com.gtja.app.operation.service.transfer.RoleTransfer;
import com.gtja.app.operation.service.transfer.UserTransfer;
import com.gtja.app.operation.service.util.AuthUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhoubo on 16/7/20.
 */
@Component
public class SystemServiceImpl implements SystemService {
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    ResourceTransfer resourceTransfer;
    @Autowired
    UserTransfer userTransfer;
    @Autowired
    RoleTransfer roleTransfer;

    @Override
    public Response<List<ResourceDTO>> getResources(GetResourcesRequest request) {
        Response response = new Response();
        RequestPagingDTO requestPagingVO = request.getRequestPagingVO();

        List<ResourceDO> resourceDOs = resourceMapper.getResources(requestPagingVO.getStart(), requestPagingVO.getSize());
        long count = resourceMapper.getResourceCount();
        List<ResourceDTO> data = resourceTransfer.convert(resourceDOs);
        response.setData(data);
        ResponsePagingDTO responsePagingVO = new ResponsePagingDTO();
        responsePagingVO.setPage(requestPagingVO.getPage());
        int size = data == null ? 0 : data.size();
        responsePagingVO.setSize(size);
        responsePagingVO.setTotalSize(count);
        response.setPagingVO(responsePagingVO);
        return response;
    }

    @Override
    public Response<ResourceDTO> getResourceById(Long id) {
        ResourceDO resourceDO = resourceMapper.getResourceById(id);
        ResourceDTO resourceDTO = resourceTransfer.convert(resourceDO);
        return Response.success(resourceDTO);
    }

    @Override
    public Response<UserDTO> getUserById(Long id) {
        UserDO userDO = userMapper.getUserById(id);
        UserDTO userDTO = userTransfer.convert(userDO);
        return Response.success(userDTO);
    }

    @Override
    public Response<RoleDTO> getRoleById(Long id) {
        RoleDO roleDO = roleMapper.getRoleById(id);
        RoleDTO roleDTO = roleTransfer.convert(roleDO);
        return Response.success(roleDTO);
    }

    @Override
    public Response<Boolean> addResource(ResourceDTO resourceDto) {
        ResourceDO resourceDO = resourceTransfer.reverseConvert(resourceDto);
        if (resourceDO != null) {
            resourceMapper.addResource(resourceDO);
        }
        return Response.success(true);
    }

    @Override
    public Response<Boolean> removeResource(Long id) {
        resourceMapper.deleteResource(id);
        return Response.success(true);
    }

    @Override
    public Response<Boolean> updateResource(ResourceDTO resourceDto) {

        ResourceDO resourceDO = resourceTransfer.reverseConvert(resourceDto);
        resourceMapper.updateResource(resourceDO);
        return Response.success(true);
    }

    @Override
    public Response<List<UserDTO>> getUsers(GetUsersRequest request) {
        Response response = new Response();
        RequestPagingDTO requestPagingVO = request.getRequestPagingVO();

        List<UserDO> userDOs = userMapper.getUsers(requestPagingVO.getStart(), requestPagingVO.getSize());
        long count = userMapper.getUserCount();
        List<UserDTO> data = userTransfer.convert(userDOs);
        response.setData(data);
        ResponsePagingDTO responsePagingVO = new ResponsePagingDTO();
        responsePagingVO.setPage(requestPagingVO.getPage());
        int size = data == null ? 0 : data.size();
        responsePagingVO.setSize(size);
        responsePagingVO.setTotalSize(count);
        response.setPagingVO(responsePagingVO);
        return response;
    }

    @Override
    public Response<LoginDTO> login(String loginName, String password) {
        UserDO userDO = userMapper.getUser(loginName, password);
        Response response = new Response();
        if (userDO == null) {
            response.setCode(401);
            response.setMsg("登录失败");
        } else {
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setToken(userDO.getId() + "");
            response.setCode(0);
            response.setData(loginDTO);
            response.setMsg("登录成功");
        }
        return response;
    }

    @Override
    public Response<Boolean> register(UserDTO userDto) {
        UserDO userDO = userTransfer.reverseConvert(userDto);
        if (userDO != null) {
            userMapper.addUser(userDO);
        }
        return Response.success(true);
    }

    @Override
    public Response<Boolean> deleteUser(Long id) {
        userMapper.deleteUser(id);
        return Response.success(true);
    }

    @Override
    public Response<Boolean> updateUser(UserDTO userDto) {
        UserDO userDO = userTransfer.reverseConvert(userDto);
        userMapper.updateUser(userDO);
        return Response.success(true);
    }

    @Override
    public Response<List<RoleDTO>> getRoles(GetRolesRequest request) {
        Response response = new Response();
        RequestPagingDTO requestPagingVO = request.getRequestPagingVO();

        List<RoleDO> roleDOs = roleMapper.getRoles(requestPagingVO.getStart(), requestPagingVO.getSize());
        long count = roleMapper.getRoleCount();
        List<RoleDTO> data = roleTransfer.convert(roleDOs);
        response.setData(data);
        ResponsePagingDTO responsePagingVO = new ResponsePagingDTO();
        responsePagingVO.setPage(requestPagingVO.getPage());
        int size = data == null ? 0 : data.size();
        responsePagingVO.setSize(size);
        responsePagingVO.setTotalSize(count);
        response.setPagingVO(responsePagingVO);
        return response;
    }

    @Override
    public Response<Boolean> addRole(RoleDTO roleDto) {
        RoleDO roleDO = roleTransfer.reverseConvert(roleDto);
        if (roleDO != null) {
            roleMapper.addRole(roleDO);
        }
        return Response.success(true);
    }

    @Override
    public Response<Boolean> deleteRole(Long id) {
        roleMapper.deleteRole(id);
        return Response.success(true);
    }

    @Override
    public Response<Boolean> updateRole(RoleDTO roleDto) {
        RoleDO roleDO = roleTransfer.reverseConvert(roleDto);
        roleMapper.updateRole(roleDO);
        return Response.success(true);
    }

    @Override
    public Response<List<ResourceDTO>> getResourceByRoleId(Long roleId) {
        List<ResourceDO> resourceDOs = resourceMapper.getResourceByRoleId(roleId);
        return Response.success(resourceTransfer.convert(resourceDOs));
    }

    @Override
    public Response<List<ResourceDTO>> getAllResources() {
        List<ResourceDO> resourceDOs = resourceMapper.getAllResources();
        return Response.success(resourceTransfer.convert(resourceDOs));
    }

    @Override
    public Response<List<RoleDTO>> getRoleByUserId(Long userId) {
        List<RoleDO> roleDOs = roleMapper.getRolesByUser(userId);
        return Response.success(roleTransfer.convert(roleDOs));
    }

    @Override
    public Response<List<RoleDTO>> getAllRoles() {
        List<RoleDO> roleDOs = roleMapper.getAllRoles();
        return Response.success(roleTransfer.convert(roleDOs));
    }

    @Override
    @Transactional
    public Response<Boolean> updateRoleResource(UpdateRoleResourceRequest request) {
        resourceMapper.deleteRoleResourceByRoleId(request.getRoleId());
        List<RoleResourceDO> roleResourceDOs = ObjectTransfer.toRoleResourceDOs(request);
        if (CollectionUtils.isNotEmpty(roleResourceDOs)) {
            resourceMapper.addRoleResource(roleResourceDOs);
        }
        return Response.success(true);
    }

    @Override
    @Transactional
    public Response<Boolean> updateUserRole(UpdateUserRoleRequest request) {
        roleMapper.deleteUserRoleByUserId(request.getUserId());
        List<UserRoleDO> userRoleDOs = ObjectTransfer.toUserRoleDO(request);
        if (CollectionUtils.isNotEmpty(userRoleDOs)) {
            roleMapper.addUserRoles(userRoleDOs);
        }
        return Response.success(true);
    }

    @Override
    public Response<List<AuthDTO>> getAuthByToken(RequestHeader request) {
        Long userId = AuthUtil.getUserId(request.getToken());
        if (userId == 0) {
            return Response.success(null);
        }
        List<RoleDO> roleDOs = roleMapper.getRolesByUser(userId);
        List<Long> roleIds = roleDOs.stream()
                .mapToLong(value -> value.getId())
                .boxed()
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(roleIds)) {
            return Response.success(null);
        }
        List<ResourceDO> resourceDOs = resourceMapper.getResourcesByRoleIds(roleIds);
        return Response.success(ObjectTransfer.toAuthDTOs(resourceDOs));
    }
}

package com.gtja.app.operation.service.controller;

import com.gtja.app.operation.api.dto.*;
import com.gtja.app.operation.api.request.*;
import com.gtja.app.operation.api.request.RequestHeader;
import com.gtja.app.operation.api.response.Response;
import com.gtja.app.operation.api.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhoubo on 16/7/19.
 */
@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/resources", method = RequestMethod.POST)
    @ResponseBody
    public Response<List<ResourceDTO>> resources(@RequestBody GetResourcesRequest request) {
        return systemService.getResources(request);
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<ResourceDTO>> getAllResources() {
        return systemService.getAllResources();
    }


    @RequestMapping(value = "/resources/add", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> addResources(@RequestBody ResourceDTO resourceDTO) {
        return systemService.addResource(resourceDTO);
    }

    @RequestMapping(value = "/resources/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<Boolean> removeResources(@PathVariable("id") long id) {
        return systemService.removeResource(id);
    }

    @RequestMapping(value = "/resources", method = RequestMethod.PUT)
    @ResponseBody
    public Response<Boolean> updateResources(@RequestBody ResourceDTO resourceDTO) {
        return systemService.updateResource(resourceDTO);
    }

    @RequestMapping(value = "/resources/{resourceId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<ResourceDTO> getResourceById(@PathVariable("resourceId") Long id) {
        return systemService.getResourceById(id);
    }


    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<RoleDTO>> getAllRoles() {
        return systemService.getAllRoles();
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    @ResponseBody
    public Response<List<RoleDTO>> roles(@RequestBody GetRolesRequest request) {
        return systemService.getRoles(request);
    }

    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> addRole(@RequestBody RoleDTO roleDTO) {
        return systemService.addRole(roleDTO);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<Boolean> removeRole(@PathVariable("id") long id) {
        return systemService.deleteRole(id);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    @ResponseBody
    public Response<Boolean> updateRole(@RequestBody RoleDTO roleDTO) {
        return systemService.updateRole(roleDTO);
    }

    @RequestMapping(value = "/roles/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<RoleDTO> getRoleById(@PathVariable("roleId") Long id) {
        return systemService.getRoleById(id);
    }

    @RequestMapping(value = "/roles/{roleId}/resources", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<ResourceDTO>> getResourceByRole(@PathVariable("roleId") Long id) {
        return systemService.getResourceByRoleId(id);
    }

    @RequestMapping(value = "/roles/{roleId}/resources", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> updateRoleResources(@RequestBody UpdateRoleResourceRequest request) {
        return systemService.updateRoleResource(request);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public Response<List<UserDTO>> users(@RequestBody GetUsersRequest request) {
        return systemService.getUsers(request);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> addUser(@RequestBody UserDTO userDTO) {
        return systemService.register(userDTO);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<Boolean> removeUser(@PathVariable("id") long id) {
        return systemService.deleteUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public Response<Boolean> updateUser(@RequestBody UserDTO userDTO) {
        return systemService.updateUser(userDTO);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<UserDTO> getUserById(@PathVariable("userId") Long id) {
        return systemService.getUserById(id);
    }


    @RequestMapping(value = "/users/{userId}/role", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<RoleDTO>> getRoleByUser(@PathVariable("userId") Long id) {
        return systemService.getRoleByUserId(id);
    }

    @RequestMapping(value = "/users/{userId}/role", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> getRoleByUser(@RequestBody UpdateUserRoleRequest request) {
        return systemService.updateUserRole(request);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response<LoginDTO> login(@RequestBody LoginRequest request) {
        return systemService.login(request.getLoginName(), request.getPassword());
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public Response<List<AuthDTO>> auth(@RequestBody RequestHeader request) {
        return systemService.getAuthByToken(request);
    }

}

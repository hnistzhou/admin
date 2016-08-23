'use strict';

var app = angular.module('operationApp', ['ngRoute', 'ui.bootstrap', 'ngCookies']);

function routeConfig($routeProvider) {
    $routeProvider.when('/system/resources', {
        controller: 'resourceListController',
        templateUrl: 'modules/system/resource/resource-list.html',
        reloadOnSearch: false
    }).when('/system/resources/add', {
        controller: 'resourceAddController',
        templateUrl: 'modules/system/resource/resource-add.html'
    }).when('/system/resources/:resourceId/edit', {
        controller: 'resourceEditController',
        templateUrl: 'modules/system/resource/resource-edit.html'
    }).when('/system/users', {
        controller: 'userListController',
        templateUrl: 'modules/system/user/user-list.html'
    }).when('/system/users/add', {
        controller: 'userAddController',
        templateUrl: 'modules/system/user/user-add.html'
    }).when('/system/users/:userId/edit', {
        controller: 'userEditController',
        templateUrl: 'modules/system/user/user-edit.html'
    }).when('/system/users/:userId/role', {
        controller: 'userRoleController',
        templateUrl: 'modules/system/user/user-role.html'
    }).when('/system/roles', {
        controller: 'roleListController',
        templateUrl: 'modules/system/role/role-list.html'
    }).when('/system/roles/add', {
        controller: 'roleAddController',
        templateUrl: 'modules/system/role/role-add.html'
    }).when('/system/roles/:roleId/edit', {
        controller: 'roleEditController',
        templateUrl: 'modules/system/role/role-edit.html'
    }).when('/system/roles/:roleId/resource', {
        controller: 'roleResourceController',
        templateUrl: 'modules/system/role/role-resource.html'
    });
// .otherwise({
//         redirectTo: '404.html'
//     });
};

app.config(routeConfig);
app.factory('authInterceptor', ['$q', '$cookieStore', '$window', function ($q, $cookieStore, $window) {
    var authInterceptor = {
        request: function (config) {
            var token = $cookieStore.get("token");
            if (token) {
                return config;
            }
            $window.location.href = "login.html";
            return config;
        }
    };
    return authInterceptor;
}]);
app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
}]);

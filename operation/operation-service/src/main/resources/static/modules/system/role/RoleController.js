app.controller('roleListController', ['$scope', '$routeParams', '$location', 'roleService',
    function ($scope, $routeParams, $location, roleService) {
        $scope.itemsPerPage = 2;
        $scope.maxSize = 5;
        $scope.totalItems = 10;
        var page = $routeParams.page;
        if (page == undefined) {
            page = 1;
        }
        $scope.currentPage = page;
        roleService.getRoles(page, $scope.itemsPerPage).then(
            function (answer) {
                $scope.dataList = answer.data.data;
                $scope.totalItems = answer.data.pagingVO.totalSize;
                $scope.totalPage = Math.ceil($scope.totalItems / $scope.itemsPerPage);
            },
            function (error) {
                $scope.error = error;
            }
        );
        $scope.pageChanged = pageChanged;
        function pageChanged() {
            var page = $scope.currentPage;
            roleService.getRoles(page, $scope.itemsPerPage).then(
                function (answer) {
                    $scope.dataList = answer.data.data;
                    $scope.totalItems = answer.data.pagingVO.totalSize;
                    $scope.totalPage = Math.ceil($scope.totalItems / $scope.itemsPerPage);
                    $location.search({page: page});
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };
        $scope.remove = function (id) {
            roleService.removeRole(id).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/roles").search({page: 1});
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };
    }]);
app.controller('roleEditController', ['$scope', '$routeParams', '$location', 'roleService',
    function ($scope, $routeParams, $location, roleService) {
        var roleId = $routeParams.roleId;
        roleService.getRoleById(roleId).then(
            function (answer) {
                var code = answer.data.code;
                if (code == 0) {
                    $scope.item = answer.data.data;
                }
            },
            function (error) {
                $scope.error = error;
            }
        );
        $scope.update = function () {
            roleService.updateRole($scope.item).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/roles");
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };
    }]);
app.controller('roleAddController', ['$scope', '$location', '$routeParams', 'roleService',
    function ($scope, $location, $routeParams, roleService) {

        $scope.save = function () {
            var item = $scope.item;
            roleService.addRole(item).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/roles");
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        }

    }]);
app.controller('roleResourceController', ['$scope', '$routeParams', '$location', 'roleService', 'resourceService', 'sortService', 'commonService',
    function ($scope, $routeParams, $location, roleService, resourceService, sortService, commonService) {
        var roleId = $routeParams.roleId;
        resourceService.getRoleResource(roleId).then(function (result) {
            var allResources = result[0].data.data;
            var rightData = result[1].data.data;
            var leftData = commonService.filterRight(allResources, rightData);
            $scope.leftData = leftData;
            $scope.rightData = rightData;
        }, function (error) {

        });
        $scope.checkAll = commonService.checkAll($scope);
        $scope.move = commonService.move($scope);



        $scope.update = function () {
            var roleId = $routeParams.roleId;
            var roleResources = $scope.rightData;
            var resourceIds = new Array();
            for (var i in roleResources) {
                resourceIds.push(roleResources[i].id);
            }
            var data = {};
            data.roleId = roleId;
            data.resourceIds = resourceIds;
            roleService.updateRoleResource(data).then(function (answer) {
                if (answer.data.code == 0) {
                    $location.path("/system/roles");
                }
            }, function (error) {

            });
        }
    }]);
app.controller('userListController', ['$scope', '$routeParams', '$location', 'userService',
    function ($scope, $routeParams, $location, userService) {
        $scope.itemsPerPage = 2;
        $scope.maxSize = 5;
        $scope.totalItems = 10;
        var page = $routeParams.page;
        if (page == undefined) {
            page = 1;
        }
        $scope.currentPage = page;
        userService.getUsers(page, $scope.itemsPerPage).then(
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
            userService.getUsers(page, $scope.itemsPerPage).then(
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
            userService.removeUser(id).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/users").search({page: 1});
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };
    }]);
app.controller('userEditController', ['$scope', '$routeParams', '$location', 'userService',
    function ($scope, $routeParams, $location, userService) {
        var userId = $routeParams.userId;
        userService.getUserById(userId).then(
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
            userService.updateUser($scope.item).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/users");
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };
        $scope.back = function () {
            window.history.back();
        }

    }]);
app.controller('userAddController', ['$scope', '$location', '$routeParams', 'userService',
    function ($scope, $location, $routeParams, userService) {

        $scope.save = function () {
            var item = $scope.item;
            userService.addUser(item).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/users");
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        }

    }]);
app.controller('userRoleController', ['$scope', '$location', '$routeParams', 'roleService', 'commonService',
    function ($scope, $location, $routeParams, roleService, commonService) {
        var userId = $routeParams.userId;
        roleService.getUserRole(userId).then(function (answer) {
            var allRoles = answer[0].data.data;
            var rightData = answer[1].data.data;
            var leftData = commonService.filterRight(allRoles, rightData);
            $scope.leftData = leftData;
            $scope.rightData = rightData;
        }, function (error) {
            $scope.error = error;
        });
        $scope.checkAll = commonService.checkAll($scope);
        $scope.move = commonService.move($scope);
        $scope.back = function () {
            window.history.back();
        };
        $scope.update = function () {
            var rightData = $scope.rightData;
            var userId = $routeParams.userId;
            var roleIds = new Array();
            if (rightData) {
                for (var i in rightData) {
                    roleIds.push(rightData[i].id);
                }
            }
            var data = {};
            data.userId = userId;
            data.roleIds = roleIds;
            roleService.updateUserRole(data).then(function (answer) {
                if (answer.data.code == 0) {
                    $location.path("/system/users");
                }
            }, function (error) {
                $scope.error = error;
            })
        }
    }]);
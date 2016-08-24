app.controller('resourceListController', ['$scope', '$routeParams', '$location', 'resourceService',
    function ($scope, $routeParams, $location, resourceService) {
        $scope.itemsPerPage = 2;
        $scope.maxSize = 5;
        //设置一个默认值,否则会触发pageChanged,并且把currentPage设置为1,导致页面跳转错误.
        // http://stackoverflow.com/questions/37466285/how-to-stay-on-current-page-after-reloading-using-angularjs-ui-bootstrap-paginat/37467738
        $scope.totalItems = 10;
        var page = $routeParams.page;
        if (page == undefined) {
            page = 1;
        }
        $scope.currentPage = page;
        resourceService.getResources(page, $scope.itemsPerPage).then(
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
            resourceService.getResources(page, $scope.itemsPerPage).then(
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
            resourceService.removeResource(id).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        pageChanged();
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };
    }]);
app.controller('resourceEditController', ['$scope', '$routeParams', '$location', 'resourceService',
    function ($scope, $routeParams, $location, resourceService) {
        var resourceId = $routeParams.resourceId;
        resourceService.getResourceById(resourceId).then(
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
            resourceService.updateResource($scope.item).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        //$location.path("/system/resources");
                        window.history.back();
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        };

    }]);
app.controller('resourceAddController', ['$scope', '$location', '$routeParams', 'resourceService',
    function ($scope, $location, $routeParams, resourceService) {

        $scope.save = function () {
            var item = $scope.item;
            resourceService.addResource(item).then(
                function (answer) {
                    var code = answer.data.code;
                    if (code == 0) {
                        $location.path("/system/resources");
                    }
                },
                function (error) {
                    $scope.error = error;
                }
            );
        }

    }]);
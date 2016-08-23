app.service('commonService', ['sortService', function (sortService) {
    return {
        checkAll: function ($scope) {
            return function (position) {
                if (position == 'left') {
                    angular.forEach($scope.leftData, function (item) {
                        item.selected = $scope.selectedAllLeft;
                    });
                }
                if (position == 'right') {
                    angular.forEach($scope.rightData, function (item) {
                        item.selected = $scope.selectedAllRight;
                    });
                }
            }
        },
        move: function ($scope) {
            return function (position) {
                var sourceList;
                var targetList;
                if (position == 'left') {
                    sourceList = $scope.leftData;
                    targetList = $scope.rightData;
                }
                if (position == 'right') {
                    sourceList = $scope.rightData;
                    targetList = $scope.leftData;
                }
                if (!sourceList) {
                    sourceList = new Array();
                }
                if (!targetList) {
                    targetList = new Array();
                }
                var addList = new Array();
                var sourceListLeft = new Array();
                for (var i in sourceList) {
                    if (sourceList[i].selected) {
                        addList.push(sourceList[i]);
                    } else {
                        sourceListLeft.push(sourceList[i]);
                    }
                }
                sortService.sortBy(sourceListLeft, 'id');
                for (x in addList) {
                    targetList.push(addList[x]);
                }
                sortService.sortBy(targetList, 'id');

                if (position == 'left') {
                    $scope.leftData = sourceListLeft;
                    $scope.rightData = targetList;
                }
                if (position == 'right') {
                    $scope.leftData = targetList;
                    $scope.rightData = sourceListLeft;
                }
            }
        },
        filterRight: function (allData, rightData) {
            if (!allData) {
                allData = new Array();
            }
            if (!rightData) {
                rightData = new Array();
            }
            var resources = new Array();
            for (var x in allData) {
                var contain = false;
                for (var y in rightData) {
                    if (rightData[y].id == allData[x].id) {
                        contain = true;
                    }
                }
                if (!contain) {
                    resources.push(allData[x]);
                }
            }
            sortService.sortBy(resources, 'id');
            return resources;
        }
    }
}]);
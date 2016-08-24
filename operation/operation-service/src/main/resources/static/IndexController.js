app.controller('indexController', ['$scope', '$rootScope', '$uibModal', '$location', '$cookieStore', '$window', 'userService',
    function ($scope, $rootScope, $uibModal, $location, $cookieStore, $window, userService) {
        $rootScope.back = function () {
            window.history.back();
        };
        var token = $cookieStore.get("token");
        userService.getAuthByToken(token).then(function (result) {
            $scope.auth = result.data.data;
        }, function (error) {
            $scope.error = error;
        });
        $scope.changeBreadCrumbs = changeBreadCrumbs;
        function changeBreadCrumbs(parent, sun) {
            $scope.primaryName = parent;
            $scope.secondaryName = sun;
        }

        $scope.changeBreadCrumbs = changeBreadCrumbs;
        function changeBreadCrumbs(parent, sun) {
            $scope.primaryName = parent;
            $scope.secondaryName = sun;
        }

        $scope.logout = logout;
        function logout() {
            $cookieStore.remove("token");
            $window.location.href = "login.html";
        }
    }]);
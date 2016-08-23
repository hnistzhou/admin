app.controller('indexController', ['$scope', '$uibModal', '$location', '$cookieStore', '$window', 'userService',
    function ($scope, $uibModal, $location, $cookieStore, $window, userService) {
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
app.service('loginService', ['$uibModal', function ($uibModal) {
    return {
        open: function () {
            var modalInstance = $uibModal.open({
                animation: true,
                backdrop: 'static',
                keyboard: false,
                templateUrl: 'login.html',
                controller: 'loginController',
                resolve: {}
            });
            return modalInstance;
        }
    }
}]);
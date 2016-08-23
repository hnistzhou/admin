app.controller('loginController', ['$scope', '$uibModalInstance', 'userService',
    function ($scope, $uibModalInstance, userService) {
        $scope.login = function () {
            var user = $scope.user;
            userService.login(user).then(function (answer) {
                var code = answer.data.code;
                if (code == 0) {
                    $uibModalInstance.close(answer.data);
                } else {
                    $scope.errorMsg = '账号或密码错误';
                }
            }, function (error) {

            });
        }
    }]);
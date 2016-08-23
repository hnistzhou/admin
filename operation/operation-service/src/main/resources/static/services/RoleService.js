app.service('roleService', ['$http', '$q', function ($http, $q) {
    return {
        getRoles: function (page, size) {
            var params = {requestPagingVO: {page: page, size: size}};
            var deferred = $q.defer();
            var promise = $http.post("/system/roles", params);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },
        addRole: function (item) {
            var deferred = $q.defer();
            var promise = $http.post("/system/roles/add", item);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },
        removeRole: function (id) {
            var deferred = $q.defer();
            var promise = $http.delete("/system/roles/" + id);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },

        updateRole: function (item) {
            var deferred = $q.defer();
            var promise = $http.put("/system/roles", item);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },
        getRoleById: function (id) {
            var deferred = $q.defer();
            var promise = $http.get("/system/roles/" + id);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },
        updateRoleResource: function (data) {
            var deferred = $q.defer();
            var promise = $http.post("/system/roles/" + data.roleId + "/resources", data);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },
        updateUserRole: function (data) {
            var deferred = $q.defer();
            var promise = $http.post("/system/users/" + data.userId + "/role", data);
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        },

        getUserRole: function (userId) {
            var rolesPromise = $http.get("/system/roles");
            var userRolePromise = $http.get("/system/users/" + userId + "/role");
            return $q.all([rolesPromise, userRolePromise]);
        },
        getRoleByUser: function (userId) {
            var deferred = $q.defer();
            var promise = $http.get("/system/users/" + userId + "/role");
            promise.then(
                function (answer) {
                    answer.status = true;
                    deferred.resolve(answer);
                },
                function (error) {
                    error.status = false;
                    deferred.reject(error);
                });
            return deferred.promise;
        }
    }
}]);
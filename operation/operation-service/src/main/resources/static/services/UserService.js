app.service('userService', ['$http', '$q', function ($http, $q) {
    return {
        getUsers: function (page, size) {
            var params = {requestPagingVO: {page: page, size: size}};
            var deferred = $q.defer();
            var promise = $http.post("/system/users", params);
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
        addUser: function (item) {
            var deferred = $q.defer();
            var promise = $http.post("/system/users/add", item);
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
        removeUser: function (id) {
            var deferred = $q.defer();
            var promise = $http.delete("/system/users/" + id);
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

        updateUser: function (item) {
            var deferred = $q.defer();
            var promise = $http.put("/system/users", item);
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
        getUserById: function (id) {
            var deferred = $q.defer();
            var promise = $http.get("/system/users/" + id);
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

        login: function (user) {
            var deferred = $q.defer();
            var promise = $http.post("/system/login", user);
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
        getAuthByToken: function (token) {
            var deferred = $q.defer();
            var promise = $http.post("/system/auth", token);
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
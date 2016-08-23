app.service('resourceService', ['$http', '$q', function ($http, $q) {
    return {
        getResources: function (page, size) {
            var params = {requestPagingVO: {page: page, size: size}};
            var deferred = $q.defer();
            var promise = $http.post("/system/resources", params);
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
        addResource: function (item) {
            var deferred = $q.defer();
            var promise = $http.post("/system/resources/add", item);
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
        removeResource: function (id) {
            var deferred = $q.defer();
            var promise = $http.delete("/system/resources/" + id);
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

        updateResource: function (item) {
            var deferred = $q.defer();
            var promise = $http.put("/system/resources", item);
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
        getResourceById: function (id) {
            var deferred = $q.defer();
            var promise = $http.get("/system/resources/" + id);
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
        getRoleResource: function (roleId) {
            var resourcePromise = $http.get("/system/resources");
            var roleResourcePromise = $http.get("/system/roles/" + roleId + "/resources");
            return $q.all([resourcePromise, roleResourcePromise]);
        }

    }
}]);
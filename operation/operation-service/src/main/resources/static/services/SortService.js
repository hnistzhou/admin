app.service('sortService', [function () {
    return (function () {
        // simple sort function
        var sortApp = {};

        sortApp.checkType = function (obj) {
            if (obj == null) {
                throw new Error({
                    name: 'Expected argument',
                    message: 'function expected parametr'
                });
            }
            return Object.prototype.toString.call(obj).slice(8, -1).toLowerCase();
        };

        sortApp.sortBy = function (data, sortedItem, desc) {
            if (!data && this.checkType(data) != 'array') {
                return false;
            }

            // some changes on dev
            // todo: mmm.. i think it's horrible
            if (typeof desc === 'boolean') {
                desc = (desc === true) ? -1 : 1;
            } else if (desc == null) {
                desc = 1;
            } else {
                throw new Error('The 3 parametr should be Boolean');
            }

            var sortFunction = function (a, b) {
                if (a[sortedItem] > b[sortedItem]) return 1 * desc;
                if (a[sortedItem] < b[sortedItem]) return -1 * desc;
                if (a[sortedItem] === a[sortedItem]) return 0;
            };

            return data.sort(sortFunction);
        };

        sortApp.render = function (arr) {
            var own = {}.hasOwnProperty, item;
            if (arr == undefined && this.checkType(arr) == 'array') {
                return false
            }
            arr.forEach(function (val, key) {
                var value;
                if (sortApp.checkType(val) == 'object') {
                    value = JSON.stringify(val);
                } else {
                    value = val;
                }
                console.log(value);
            });
        }

        sortApp.renderHtmlUl = function (arr) {
            var own = {}.hasOwnProperty;
            if (this.checkType(arr) != 'array') {
                return false;
            }

            var str = "";
            str = '<ul>';
            for (var i = 0; i <= arr.length; i++) {
                if (own.call(arr, i)) {
                    if (this.checkType(arr[i])) {
                        str += "<li>" + JSON.stringify(arr[i]) + "</li>";
                    } else {
                        str += "<li>" + arr[i] + "</li>";
                    }
                }
            }
            str += '</ul>';
            return str;
        };
        return sortApp;
    })();
}]);
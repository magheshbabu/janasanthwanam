(function() {
    'use strict';
    angular
        .module('janasanthwanamApp')
        .factory('Apeksha', Apeksha);

    Apeksha.$inject = ['$resource', 'DateUtils'];

    function Apeksha ($resource, DateUtils) {
        var resourceUrl =  'api/apekshas/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dateOfBirth = DateUtils.convertLocalDateFromServer(data.dateOfBirth);
                        data.dateOfApplcation = DateUtils.convertLocalDateFromServer(data.dateOfApplcation);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateOfBirth = DateUtils.convertLocalDateToServer(copy.dateOfBirth);
                    copy.dateOfApplcation = DateUtils.convertLocalDateToServer(copy.dateOfApplcation);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateOfBirth = DateUtils.convertLocalDateToServer(copy.dateOfBirth);
                    copy.dateOfApplcation = DateUtils.convertLocalDateToServer(copy.dateOfApplcation);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();

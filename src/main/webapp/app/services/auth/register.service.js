(function () {
    'use strict';

    angular
        .module('janasanthwanamApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();

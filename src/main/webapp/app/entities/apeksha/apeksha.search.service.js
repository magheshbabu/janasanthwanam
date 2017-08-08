(function() {
    'use strict';

    angular
        .module('janasanthwanamApp')
        .factory('ApekshaSearch', ApekshaSearch);

    ApekshaSearch.$inject = ['$resource'];

    function ApekshaSearch($resource) {
        var resourceUrl =  'api/_search/apekshas/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();

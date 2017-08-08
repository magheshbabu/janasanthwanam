(function() {
    'use strict';

    angular
        .module('janasanthwanamApp')
        .controller('ApekshaDetailController', ApekshaDetailController);

    ApekshaDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Apeksha'];

    function ApekshaDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Apeksha) {
        var vm = this;

        vm.apeksha = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('janasanthwanamApp:apekshaUpdate', function(event, result) {
            vm.apeksha = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();

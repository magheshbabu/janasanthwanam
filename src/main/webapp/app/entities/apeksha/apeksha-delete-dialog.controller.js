(function() {
    'use strict';

    angular
        .module('janasanthwanamApp')
        .controller('ApekshaDeleteController',ApekshaDeleteController);

    ApekshaDeleteController.$inject = ['$uibModalInstance', 'entity', 'Apeksha'];

    function ApekshaDeleteController($uibModalInstance, entity, Apeksha) {
        var vm = this;

        vm.apeksha = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Apeksha.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();

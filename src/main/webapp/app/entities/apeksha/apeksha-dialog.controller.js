(function() {
    'use strict';

    angular
        .module('janasanthwanamApp')
        .controller('ApekshaDialogController', ApekshaDialogController);

    ApekshaDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'Apeksha'];

    function ApekshaDialogController ($timeout, $scope, $stateParams, $uibModalInstance, DataUtils, entity, Apeksha) {
        var vm = this;

        vm.apeksha = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.apeksha.id !== null) {
                Apeksha.update(vm.apeksha, onSaveSuccess, onSaveError);
            } else {
                Apeksha.save(vm.apeksha, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('janasanthwanamApp:apekshaUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.dateOfBirth = false;

        vm.setAdditionalDocuments = function ($file, apeksha) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        apeksha.additionalDocuments = base64Data;
                        apeksha.additionalDocumentsContentType = $file.type;
                    });
                });
            }
        };
        vm.datePickerOpenStatus.dateOfApplcation = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();

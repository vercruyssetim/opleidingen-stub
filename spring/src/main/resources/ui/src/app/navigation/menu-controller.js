const menuCtrl = function($scope, $location){
    $scope.$location = $location;
};

menuCtrl.$inject = ['$location'];

export default menuCtrl;
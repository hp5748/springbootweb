let app=angular.module('myApp',[]);
app.controller('myCtrl',['$scope',function ($scope) {
    $scope.data={'name':'和平'};
    alert(angular.toJson($scope.data));

}]);
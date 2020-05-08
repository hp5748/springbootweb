//控制器定义
// var actionApp=angular.module('')
actionApp.controller('View1Controller',['$rootScope','$scope','$http',function($rootScope,$scope,$http){
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面1加载完成！');
    });

    $scope.search=function () {//定义个search,在页面上用ng-click调用
        let personName=$scope.personName;
        $http.get('search',{params:{personName:personName}}).success(
            function (data) {
                $scope.person=data;
            }
        );
    };

}]);

actionApp.controller('View2Controller',['$rootScope','$scope','$http',function($rootScope,$scope,$http){
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面2加载完成！');
    });
}]);
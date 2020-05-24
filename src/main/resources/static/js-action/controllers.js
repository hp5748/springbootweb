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
              console.log("返回值开始"+data);
               $scope.person=data;
          console.log("返回值结束！");
            }
        );
    };

}]);

actionApp.controller('View2Controller',['$rootScope','$scope','$http',function($rootScope,$scope,$http){
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面2加载完成！');
    });
}]);
actionApp.controller('View3Controller',['$rootScope','$scope','$http',function($rootScope,$scope,$http){
    $scope.$on('$viewContentLoaded',function () {
        console.log('页面3加载完成！');
    });
}]);
actionApp.controller('AccMaController',['$rootScope','$scope','$http',function($rootScope,$scope,$http){
    $scope.$on('$viewContentLoaded',function () {
        $scope.getUsers();
        console.log('页面3加载完成！');
    });
    //获取所有账户
    $scope.getUsers=function () {//定义getUsers无参get请求,在页面加载显示
            $http.get('getUsers').success(
            function (data) {
                console.log(data);
                $scope.person=data;
                console.log("返回值结束！");
            }
        );
    };

    $scope.modifyUser=function (param) {
               console.log(param);
           $scope.account=param;
    }

}]);
//AccMaController
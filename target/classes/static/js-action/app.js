let actionApp=angular.module('actionApp',['ngRoute']);
actionApp.config(['$routeProvider',function ($routeProvider) {
    $routeProvider.when('/open',{
        controller:'View1Controller',//路由控制器名称
        templateUrl:'/static/views/view1.html',//视图真正地址
    }).when('/directive',{
        controller:'View2Controller',
        templateUrl:'/static/views/view2.html',
    });
}]);

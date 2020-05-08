//自定义指令
//定制一个封装jqueryui的dataPicker的指令
actionApp.directive('datePicker',function(){  //指令名为datePicker
    return {
        restrict: 'AC',  //属性指令和样式指令
        //使用link方法来定义指令，在link方法内可使用当前scope、当前元素及元素属性
        link:function(scope,elem,attrs){
            //初始化jqueryui的dataPicker
            elem.datapicker();
        }
    };
});
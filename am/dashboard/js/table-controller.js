var app =angular.module('tables',['ui.bootstrap','ui.utils'])

app.controller('table',function($scope,$http){
    $scope.users = [];
    console.log('teste')
    $http({
        method:"GET",
        url:"http://localhost:8080/usuario/listar"
    }).then(function(response){
        console.log("response")
        $scope.users = response.data;
    });
    $scope.dataTableOpt = {
        //custom datatable options 
       // or load data through ajax call also
       "aLengthMenu": [[10, 50, 100,-1], [10, 50, 100,'All']],
       };
});
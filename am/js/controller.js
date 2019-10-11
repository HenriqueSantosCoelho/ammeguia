angular.module('app',[]).controller('controller',function($scope,$http){
    $scope.showMsg = false;
    $scope.inserirMsg =function(msg){
        $http({
            method:"POST",
            url:"http://localhost:8080/sugestao/cadastrar",
            data:msg
        }).then(function(response){
            $scope.showMsg = true;
            clearFields();
        });
    }


    $http({
        method:"GET",
        url:"http://localhost:8080/problema/listar"
    }).then(response => console.log(response.data.result));



    function clearFields(){
        $scope.msg = {};   
    }
});
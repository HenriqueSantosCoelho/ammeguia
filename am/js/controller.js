angular.module('app',[]).controller('controller',function($scope,$http){
    $scope.showMsg = false;
    $scope.inserirMsg =function(msg){
        $http({
            method:"POST",
            url:"https://serene-thicket-17017.herokuapp.com/sugestao/cadastrar",
            data:msg
        }).then(function(response){
            $scope.showMsg = true;
            clearFields();
        });
    }


    $http({
        method:"GET",
        url:"https://serene-thicket-17017.herokuapp.com/problema/listar"
    }).then(response => console.log(response.data.result));



    function clearFields(){
        $scope.msg = {};   
    }
});
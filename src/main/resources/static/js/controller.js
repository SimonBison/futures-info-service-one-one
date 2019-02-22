var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "futures/create";

        var config = {
            headers : {
                'Accept': 'text/plain'
            }
        }
        var data = {
            futuresGroup: $scope.futuresGroup,
            futuresMargin: $scope.futuresMargin,
            futuresName: $scope.futuresName,
            futuresSymbol: $scope.futuresSymbol
        };

        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = response.data;
        //}, function error(response) {
            //$scope.postResultMessage = "Error with status: " +  response.statusText;
        });

        $scope.futuresGroup = "";
        $scope.futuresMargin = "";
        $scope.futuresName = "";
        $scope.futuresSymbol = "";
    }
});

app.controller('getcontroller', function($scope, $http, $location) {
    $scope.getfunction = function(){
        var url = $location.absUrl() + "futures/all";

        $http.get(url).then(function (response) {
            $scope.response = response.data
        //}, function error(response) {
            //$scope.postResultMessage = "Error with status: " +  response.statusText;
        });
    }
});
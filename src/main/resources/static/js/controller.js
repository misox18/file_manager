var app = angular.module('app', []);
app.controller('controller', function($scope, $http, $filter) {

	$scope.getData = function() {
		$scope.items = [];
		$scope.path = [];
		
		$http.get("/getItems").then(function(response) {
			$scope.items = response.data;
			$scope.message = response.message;
		}, function error(response) {
			$scope.message = response.message;
		})
		
		$http.get("/getPath").then(function (response) {
			$scope.path = response.data;
			$scope.message = response.message;
		}), function error(response) {
			$scope.message = response.message;
		}
	}	
	
});
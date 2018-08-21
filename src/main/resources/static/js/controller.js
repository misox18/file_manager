var app = angular.module('app', []);
app.controller('controller', function($scope, $http, $filter) {

	$scope.getItems = function() {
		$scope.items = [];
		
		$http.get("/getItems").then(function(response) {
			$scope.items = response.data;
			$scope.message = response.message;
		}, function error(response) {
			$scope.message = response.message;
		})
	}	
	
	var findItems = function() {
		$http.get("/findItems");
	}
	
	findItems();
});
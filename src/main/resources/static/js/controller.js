var app = angular.module('app', []);
app.controller('controller', function($scope, $http, $filter) {
	
	$scope.getItems = function() {
		$scope.items = [];
		
		$http.get("/allItems").then(function(response) {
			$scope.items = response.data;
			$scope.message = response.message;
		}, function error(response) {
			$scope.message = response.message;
		})
	}	
});
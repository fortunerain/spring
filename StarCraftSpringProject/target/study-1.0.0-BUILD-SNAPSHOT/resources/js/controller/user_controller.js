app.controller('ngController',function($scope, $http) {
	//scope : 사전적 의미로 범위. jsp단의 ng-model으로 선언한 것과 관련있다.
	
	$scope.first="홍";
	$scope.last="길동";
	$scope.head="메세지 : ";
	$scope.updateMessage = function(){
		$scope.message = "hi"+$scope.first+$scope.last;
		
	    $http.get("/star/getData").then(function (response) {
	        $scope.myData = response.data;
	    });
	    
	};
});

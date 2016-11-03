app.controller('HomeController',function($scope, $http) {
	var main = this;
	alert(main.id);
    var reqPromise = $http.get('http://localhost:8080/star/home2');
//$http서비스의 get 단축메소드를 사용하였다. 이전 코드보다 더욱 간결해진 것을 볼 수 있다.
    alert(1);
    alert($http);
    alert($scope.userList);

    reqPromise.success(function(data) {
      $scope.userList = data;
    });

    reqPromise.error(function(data) {
      console.error("Ajax 에러 발생");
    });
});

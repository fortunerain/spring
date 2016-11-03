<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Hello AngularJS</title>
<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>

<body ng-app="myApp">
  <div class="container">
    <h1>Greeting</h1>
    <div ng-controller="HomeController" ng-model="greeting" ng-cloak class="ng-cloak">
      <p>The ID is {{greeting.id}}</p>
      <p>The content is {{greeting.content}}</p>
    </div>
  </div>
  
  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script> -->
  <script src="<c:url value='/resources/js/app.js' />"></script>
  <script src="<c:url value='/resources/js/service/user_service.js' />"></script>
  <script src="<c:url value='/resources/js/controller/user_controller.js' />"></script>
</body>
</html>

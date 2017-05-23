//Deze file is de wegwijzer van alle pagina's op die site. Deze linked de partials aan de main site.

var app = angular.module('myApp', ['ngRoute','myApp.indexController']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl : 'partials/cart.html',
        controller: 'myApp.indexController'
    })
}]);